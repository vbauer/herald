package com.github.vbauer.herald.logger;

/**
 * Basic contract-interface to describe logger factory, which creates logger objects.
 *
 * @author Vladislav Bauer
 */

public interface LogFactory {

    /**
     * Check if logger class is compatible with the log factory.
     *
     * @param loggerClass logger class
     * @return true if compatible and false - otherwise
     */
    boolean isCompatible(Class<?> loggerClass);

    /**
     * Create logger with the given name (as configuration parameter).
     *
     * @param name logger name
     * @return logger instance
     */
    Object createLogger(String name);

    /**
     * Create logger with the given class (as configuration parameter).
     *
     * @param clazz class
     * @return logger instance
     */
    Object createLogger(Class<?> clazz);

}
