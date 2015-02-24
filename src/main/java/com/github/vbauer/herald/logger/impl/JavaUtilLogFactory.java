package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("unused")
public class JavaUtilLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "java.util.logging.Logger";
    public static final String FACTORY_CLASS_NAME = LOGGER_CLASS_NAME;
    public static final String FACTORY_METHOD_NAME = "getLogger";

    
    public JavaUtilLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }

    
    @Override
    public Object createLogger(Class<?> clazz) {
        return createLogger(clazz.getSimpleName());
    }
    
}
