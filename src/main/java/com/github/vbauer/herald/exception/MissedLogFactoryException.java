package com.github.vbauer.herald.exception;

import com.github.vbauer.herald.annotation.Log;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class MissedLogFactoryException extends RuntimeException {

    private final Class<?> loggerClass;
    private final Log logAnnotation;


    public MissedLogFactoryException(final Class<?> loggerClass, final Log logAnnotation) {
        this.loggerClass = loggerClass;
        this.logAnnotation = logAnnotation;
    }


    public Class<?> getLoggerClass() {
        return loggerClass;
    }

    public Log getLogAnnotation() {
        return logAnnotation;
    }


    @Override
    public String getMessage() {
        return String.format("Can not find log factory for logger %s", getLoggerClass());
    }

}
