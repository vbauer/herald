package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.logger.LogFactory;
import com.github.vbauer.jackdaw.annotation.JService;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
@JService(LogFactory.class)
public class CommonsLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.apache.commons.logging.Log";
    public static final String FACTORY_CLASS_NAME = "org.apache.commons.logging.LogFactory";
    public static final String FACTORY_METHOD_NAME = "getLog";


    public CommonsLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }
    
}
