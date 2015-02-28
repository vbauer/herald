package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
public class Log4jLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.apache.log4j.Logger";
    public static final String FACTORY_CLASS_NAME = LOGGER_CLASS_NAME;
    public static final String FACTORY_METHOD_NAME = "getLogger";


    public Log4jLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }
    
}
