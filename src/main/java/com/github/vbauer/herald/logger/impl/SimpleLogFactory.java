package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.logger.LogFactory;
import com.github.vbauer.herald.util.ReflectionUtils;

/**
 * @author Vladislav Bauer
 */

public abstract class SimpleLogFactory implements LogFactory {

    @Override
    public boolean isCompatible(final Class<?> loggerClass) {
        final String loggerClassName = getLoggerClassName();
        return ReflectionUtils.isAssignableFrom(loggerClassName, loggerClass);
    }

    @Override
    public Object createLogger(final Class<?> clazz) {
        return createLogger(clazz.getSimpleName());
    }


    public abstract String getLoggerClassName();

}
