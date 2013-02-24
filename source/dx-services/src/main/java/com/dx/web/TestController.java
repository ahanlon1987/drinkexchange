package com.dx.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController extends AbstractController {


    private static Logger log = LoggerFactory.getLogger(TestController.class);



    @ResponseBody
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public String testOrdersURI(  HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        log.warn("findOrdersByOrg start");

        return this.writeResponse("dx-services are running");
    }

}
