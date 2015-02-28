package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
public class Slf4jExtLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.slf4j.ext.XLogger";
    public static final String FACTORY_CLASS_NAME = "org.slf4j.ext.XLoggerFactory";
    public static final String FACTORY_METHOD_NAME = "getXLogger";


    public Slf4jExtLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }

}
