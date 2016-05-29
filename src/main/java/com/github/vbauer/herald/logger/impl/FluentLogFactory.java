package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.logger.LogFactory;
import com.github.vbauer.jackdaw.annotation.JService;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
@JService(LogFactory.class)
public class FluentLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.fluentd.logger.FluentLogger";
    public static final String FACTORY_CLASS_NAME = LOGGER_CLASS_NAME;
    public static final String FACTORY_METHOD_NAME = "getLogger";


    public FluentLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object createLogger(final Class<?> clazz) {
        return createLogger(clazz.getSimpleName());
    }
    
}
