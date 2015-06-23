package com.github.vbauer.herald.exception;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class MissedLogFactoryException extends HeraldException {

    private final Class<?> loggerClass;


    public MissedLogFactoryException(final Class<?> loggerClass) {
        this.loggerClass = loggerClass;
    }


    public Class<?> getLoggerClass() {
        return loggerClass;
    }


    @Override
    public String getMessage() {
        return String.format("Can not find log factory for logger %s", getLoggerClass());
    }

}
