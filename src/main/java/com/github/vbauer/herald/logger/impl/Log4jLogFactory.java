package com.github.vbauer.herald.logger.impl;

import com.github.vbauer.herald.logger.LogFactory;
import com.github.vbauer.jackdaw.annotation.JService;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
@JService(LogFactory.class)
public class Log4jLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.apache.log4j.Logger";
    public static final String FACTORY_CLASS_NAME = LOGGER_CLASS_NAME;
    public static final String FACTORY_METHOD_NAME = "getLogger";


    public Log4jLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }
    
}
