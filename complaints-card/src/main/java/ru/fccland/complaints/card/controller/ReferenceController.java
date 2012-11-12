package ru.fccland.complaints.card.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.fccland.complaints.card.service.CategoryService;
import ru.fccland.complaints.card.service.DepartmentService;


/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 12.11.12
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/ref")
public class ReferenceController {
    protected static Logger logger = Logger.getLogger("ref-controller");

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/departments",
            method = RequestMethod.GET,
            headers="Accept=application/xml, application/json")
    public @ResponseBody DepartmentList getDepartments() {
        logger.debug("Provider has received request to get all departments");

        DepartmentList result = new DepartmentList();
        result.setData(departmentService.list());

        return result;
    }

    @RequestMapping(value = "/categories",
            method = RequestMethod.GET,
            headers="Accept=application/xml, application/json")
    public @ResponseBody CategoryList getCategories() {
        logger.debug("Provider has received request to get all categories");

        CategoryList result = new CategoryList();
        result.setData(categoryService.list());

        return result;
    }

}
