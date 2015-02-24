package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("unused")
public class Slf4jLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.slf4j.Logger";
    public static final String FACTORY_CLASS_NAME = "org.slf4j.LoggerFactory";
    public static final String FACTORY_METHOD_NAME = "getLogger";


    public Slf4jLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }
    
}
