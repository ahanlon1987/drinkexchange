package com.dx.web;

import com.dx.view.ErrorView;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController {
    private static Logger log = LoggerFactory.getLogger(AbstractController.class);
    private static ObjectMapper jsonMapper = new ObjectMapper();


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody()
    @ExceptionHandler({Exception.class})
    public String handleException(Exception e, HttpServletResponse response) throws Exception {
        log.error("Exception occurred, sending INTERNAL_SERVER_ERROR error code.", e);
        ErrorView view = new ErrorView();
        if(e != null) {
            view.setMessage(e.getMessage());
        }
        return writeResponse(view);
    }

    protected static String writeResponse(Object resource) throws Exception {
        log.warn("controller begin write response");
        String response = null;
        try {
            response = jsonMapper.writeValueAsString(resource);
        } catch(IOException e) {
            throw new Exception("Failed to write json response.", e);
        }
        log.warn("controller write response end");
        return response;
    }

}