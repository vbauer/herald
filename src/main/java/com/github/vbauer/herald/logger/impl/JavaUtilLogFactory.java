package com.github.vbauer.herald.logger.impl;

import java.util.logging.Logger;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("unused")
public class JavaUtilLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "java.util.logging.Logger";


    @Override
    public String getLoggerClassName() {
        return LOGGER_CLASS_NAME;
    }

    @Override
    public Object createLogger(final String name) {
        return Logger.getLogger(name);
    }

}
