package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.util.ReflectionUtils;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("unused")
public class Slf4jExtLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.slf4j.ext.XLogger";
    public static final String FACTORY_CLASS_NAME = "org.slf4j.ext.XLoggerFactory";
    public static final String FACTORY_METHOD_NAME = "getXLogger";


    @Override
    public Object createLogger(final Class<?> clazz) {
        return ReflectionUtils.invokeStatic(FACTORY_CLASS_NAME, FACTORY_METHOD_NAME, clazz);
    }

    @Override
    public Object createLogger(final String name) {
        return ReflectionUtils.invokeStatic(FACTORY_CLASS_NAME, FACTORY_METHOD_NAME, name);
    }

    @Override
    protected String getLoggerClassName() {
        return LOGGER_CLASS_NAME;
    }
    
}
