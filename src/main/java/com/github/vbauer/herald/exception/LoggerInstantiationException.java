package com.github.vbauer.herald.exception;

import com.github.vbauer.herald.logger.LogFactory;

/**
 * An exception class for situations when we do not have possibility to create logger.
 * Some problems were occurred during logger creation.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public class LoggerInstantiationException extends HeraldException {

    private final LogFactory loggerFactory;


    public LoggerInstantiationException(final LogFactory loggerFactory) {
        this.loggerFactory = loggerFactory;
    }


    /**
     * Get logger factory, see {@link LogFactory}.
     *
     * @return logger factory
     */
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
