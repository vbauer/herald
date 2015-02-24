package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer 
 */

@SuppressWarnings("unused")
public class Log4j2LogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.apache.logging.log4j.Logger";
    public static final String FACTORY_CLASS_NAME = "org.apache.logging.log4j.LogManager";
    public static final String FACTORY_METHOD_NAME = "getLogger";


    public Log4j2LogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }

}
