package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.logger.LogFactory;
import com.github.vbauer.herald.util.ReflectionUtils;

/**
 * @author Vladislav Bauer
 */

public abstract class SimpleLogFactory implements LogFactory {

    private final String loggerClassName;
    private final String loggerFactoryClassName;
    private final String loggerFactoryMethod;
    
            
    protected SimpleLogFactory(
        final String loggerClassName,
        final String loggerFactoryClassName, final String loggerFactoryMethod
    ) {
        this.loggerClassName = loggerClassName;
        this.loggerFactoryClassName = loggerFactoryClassName;
        this.loggerFactoryMethod = loggerFactoryMethod;
    }
    

    @Override
    public boolean isCompatible(final Class<?> loggerClass) {
        return ReflectionUtils.isAssignableFrom(loggerClassName, loggerClass);
    }

    @Override
    public Object createLogger(final Class<?> clazz) {
        return createLoggerObject(clazz);
    }

    @Override
    public Object createLogger(final String name) {
        return createLoggerObject(name);
    }


    private Object createLoggerObject(final Object id) {
        return ReflectionUtils.invokeStatic(
            loggerFactoryClassName,
            loggerFactoryMethod,
            id
        );
    }

}
