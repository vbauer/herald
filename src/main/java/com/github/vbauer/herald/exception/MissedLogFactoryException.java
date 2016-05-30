package com.github.vbauer.herald.exception;

/**
 * An exception class for situations when log factory could not be detected for the given logger.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class MissedLogFactoryException extends HeraldException {

    private final Class<?> loggerClass;


    public MissedLogFactoryException(final Class<?> loggerClass) {
        this.loggerClass = loggerClass;
    }


    /**
     * Get logger class.
     *
     * @return logger class
     */
    public Class<?> getLoggerClass() {
        return loggerClass;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return String.format("Can not find log factory for logger %s", getLoggerClass());
    }

}
