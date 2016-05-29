package com.github.vbauer.herald.exception;

import com.github.vbauer.herald.logger.LogFactory;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class LoggerInstantiationException extends HeraldException {

    private final LogFactory loggerFactory;


    public LoggerInstantiationException(final LogFactory loggerFactory) {
        this.loggerFactory = loggerFactory;
    }


    public LogFactory getLoggerFactory() {
        return loggerFactory;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return String.format("Can't create logger using factory %s", getLoggerFactory());
    }

}
