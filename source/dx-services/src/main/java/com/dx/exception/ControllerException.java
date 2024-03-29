package com.dx.exception;

public class ControllerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ControllerException(String msg) {
        super(msg);
    }

    public ControllerException(Throwable t) {
        super(t);
    }

    public ControllerException(String msg, Throwable t) {
        super(msg, t);
    }

}
