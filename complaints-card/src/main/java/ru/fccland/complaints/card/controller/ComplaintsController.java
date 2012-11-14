package ru.fccland.complaints.card.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.fccland.complaints.card.domain.UploadedFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 13.11.12
 * Time: 8:57
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/")
public class ComplaintsController {
    protected static Logger log = Logger.getLogger("cmpl-controller");

    @Value("${cmpl.temp.dir}")
    private String tempDirectoryName;


    private String getHttpSessionId() {
        return  ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getId();
    }

    @RequestMapping
    public String form(){
        String remoteAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        String sessionId = getHttpSessionId();

        ComplaintsController.createSessionTempFolder(tempDirectoryName, sessionId);

        if(log.isDebugEnabled())
            log.debug("ComplaintsController.index(), session-id = " + sessionId);

        return "form";
    }

    @RequestMapping(value="/fileupload", method=RequestMethod.POST)
    public @ResponseBody
    List<UploadedFile> upload(
            @RequestParam("file") MultipartFile file) {
        if(log.isDebugEnabled())
            log.debug("ComplaintsController.upload(), file: " + file.getOriginalFilename() + " - " + file.getSize() + " bytes");

        try {
            File f = new File(tempDirectoryName+File.separator+getHttpSessionId() + File.separator + file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(file.getBytes());
            fos.close();
        } catch (Exception e) {
            log.error(e);
            return null;
        }

        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
        UploadedFile u = new UploadedFile();
        u.setName(file.getOriginalFilename());
        u.setSize(Long.valueOf(file.getSize()).intValue());
        uploadedFiles.add(u);

        return uploadedFiles;
    }

    public static synchronized void createSessionTempFolder(String tempDirectoryName, String sessionId) {
        File tempDirectory = new File(tempDirectoryName);
        if(tempDirectory.exists() && tempDirectory.isDirectory()) {
            boolean success = (
                    new File(tempDirectoryName + File.separator + sessionId.trim())).mkdir();
            if (success) {
                if(log.isDebugEnabled())
                    log.debug("Temporary session directory '"+sessionId+"' created in '" + tempDirectoryName+ "', ${temp.dir} not exist.");
            }
        } else
            log.error("Error create  temporary session directory '" + sessionId + "' in '" + tempDirectoryName + "', ${temp.dir} not exist.");
    }

}