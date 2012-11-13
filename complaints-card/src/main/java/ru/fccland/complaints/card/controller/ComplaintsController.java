package ru.fccland.complaints.card.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld(){

        ModelAndView model = new ModelAndView("form");
        model.addObject("msg", "hello world");
        return model;
    }

}
