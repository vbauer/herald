package com.github.vbauer.herald.logger;

/**
 * @author Vladislav Bauer
 */

public interface LogFactory {

    boolean isCompatible(Class<?> loggerClass);

    Object createLogger(String name);

    Object createLogger(Class<?> clazz);

}
