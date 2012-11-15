package ru.fccland.complaints.card.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.fccland.complaints.card.domain.Message;
import ru.fccland.complaints.card.domain.UploadedFile;
import ru.fccland.complaints.card.responces.StatusResponse;
import ru.fccland.complaints.card.service.CategoryService;
import ru.fccland.complaints.card.service.ComplaintAuthorService;
import ru.fccland.complaints.card.service.DepartmentService;
import ru.fccland.complaints.card.service.DocTypeService;

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

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ComplaintAuthorService complaintAuthorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DocTypeService docTypeService;


    private String getHttpSessionId() {
        return  ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getId();
    }

    private String getRemoteAddress() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
    }

    @RequestMapping
    public String form(){

        String sessionId = getHttpSessionId();

        ComplaintsController.createSessionTempFolder(tempDirectoryName, sessionId);

        if(log.isDebugEnabled())
            log.debug("ComplaintsController.index(sid="+sessionId+")");

        return "form";
    }

    @RequestMapping(value ="/sendform", method=RequestMethod.POST)
    public @ResponseBody
    StatusResponse sendform(@RequestBody Message message) {
        String sessionId = getHttpSessionId();
        if(log.isDebugEnabled())
            log.debug("ComplaintsController.sendform(sid="+sessionId+"): " + message);

        //categoryService

        return  new StatusResponse(true, "Ваша жалоба поставлена в очередь на обработку");
    }

    @RequestMapping(value="/fileupload", method=RequestMethod.POST)
    public @ResponseBody
    List<UploadedFile> upload(
            @RequestParam("file") MultipartFile file) {
        String sessionId = getHttpSessionId();
        if(log.isDebugEnabled())
            log.debug("ComplaintsController.upload(sid="+sessionId+"), file: " + file.getOriginalFilename() + " - " + file.getSize() + " bytes");
        String fileName = tempDirectoryName+File.separator+getHttpSessionId() + File.separator + file.getOriginalFilename();
        try {
            File f = new File(fileName);
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(file.getBytes());
            fos.close();
        } catch (Exception e) {
            log.error("Error save uploaded file, sid: "+sessionId+", file: " + fileName, e);
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
