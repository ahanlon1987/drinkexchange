package com.dx.view;

import java.io.Serializable;

public class ErrorView implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ***********************************************************************
     * <p/>
     * MEMBER VARIABLES
     * <p/>
     * ***********************************************************************
     */
    private String message;

    private String uri;


    /**
     * ***********************************************************************
     * <p/>
     * GETTERS
     * <p/>
     * ***********************************************************************
     */
    public String getMessage() {
        return message;
    }
    public String getUri() {
        return uri;
    }


    /**
     * ***********************************************************************
     * <p/>
     * SETTERS
     * <p/>
     * ***********************************************************************
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
