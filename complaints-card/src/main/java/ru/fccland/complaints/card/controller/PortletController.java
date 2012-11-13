package ru.fccland.complaints.card.controller;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 13.11.12
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class PortletController extends AbstractController {

    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("message", "Check it out!");
        return mav;
    }

}
