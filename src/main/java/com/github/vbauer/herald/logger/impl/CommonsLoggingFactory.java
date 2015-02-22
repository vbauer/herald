package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.util.ReflectionUtils;

/**
 * @author Vladislav Bauer
 */

public class CommonsLoggingFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.apache.commons.logging.Log";
    public static final String FACTORY_CLASS_NAME = "org.apache.commons.logging.LogFactory";
    public static final String FACTORY_METHOD_NAME = "getLog";


    @Override
    public String getLoggerClassName() {
        return LOGGER_CLASS_NAME;
    }

    @Override
    public Object createLogger(final Class<?> clazz) {
        return ReflectionUtils.invokeStatic(FACTORY_CLASS_NAME, FACTORY_METHOD_NAME, clazz);
    }

    @Override
    public Object createLogger(final String name) {
        return ReflectionUtils.invokeStatic(FACTORY_CLASS_NAME, FACTORY_METHOD_NAME, name);
    }

}

