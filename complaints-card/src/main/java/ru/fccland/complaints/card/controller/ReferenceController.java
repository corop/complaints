package ru.fccland.complaints.card.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.fccland.complaints.card.service.CategoryService;
import ru.fccland.complaints.card.service.ComplaintAuthorService;
import ru.fccland.complaints.card.service.DepartmentService;
import ru.fccland.complaints.card.service.DocTypeService;


/**
 * REST service for references data
 * Access for example - http://localhost:8080/ref/departments
 * User: asergeev
 * Date: 12.11.12
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/ref")
public class ReferenceController {
    protected static Logger log = Logger.getLogger("ref-controller");

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ComplaintAuthorService complaintAuthorService;

    @Autowired
    private DocTypeService docTypeService;

    @RequestMapping(value = "/departments",
            method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    DepartmentList getDepartments() {
        if(log.isDebugEnabled()) {
            log.debug("Provider has received request to get all departments");
            String sessionId = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getId();
            log.debug("ReferenceController.getDepartments(), session-id = " + sessionId);
        }
        DepartmentList result = new DepartmentList();
        result.setData(departmentService.list());

        return result;
    }

    @RequestMapping(value = "/categories",
            method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    CategoryList getCategories() {
        if(log.isDebugEnabled()) {
            log.debug("Provider has received request to get all categories");
            String sessionId = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getId();
            log.debug("ReferenceController.getCategories(), session-id = " + sessionId);
        }

        CategoryList result = new CategoryList();
        result.setData(categoryService.list());

        return result;
    }

    @RequestMapping(value = "/authors",
            method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    ComplaintAuthorList getComplaintAuthors() {
        if(log.isDebugEnabled()) {
            log.debug("Provider has received request to get all Complaint authors types");
            String sessionId = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getId();
            log.debug("ReferenceController.getComplaintAuthors(), session-id = " + sessionId);
        }

            ComplaintAuthorList result = new ComplaintAuthorList();
        result.setData(complaintAuthorService.list());

        return result;
    }

    @RequestMapping(value = "/doctypes",
            method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json")
    public
    @ResponseBody
    DocTypeList getDocTypes() {
        if(log.isDebugEnabled()) {
            log.debug("Provider has received request to get all document types");
            String sessionId = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getId();
            log.debug("ReferenceController.getDocTypes(), session-id = " + sessionId);
        }

        DocTypeList result = new DocTypeList();
        result.setData(docTypeService.list());

        return result;
    }


}
