package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.util.ReflectionUtils;

/**
 * @author Vladislav Bauer 
 */

@SuppressWarnings("unused")
public class Log4j2LogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.apache.logging.log4j.Logger";
    public static final String FACTORY_CLASS_NAME = "org.apache.logging.log4j.LogManager";
    public static final String FACTORY_METHOD_NAME = "getLogger";


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
