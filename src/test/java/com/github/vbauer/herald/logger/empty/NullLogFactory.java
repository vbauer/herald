package com.github.vbauer.herald.logger.empty;

import com.github.vbauer.herald.logger.LogFactory;
import com.github.vbauer.herald.logger.impl.SimpleLogFactory;
import com.github.vbauer.jackdaw.annotation.JService;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
@JService(LogFactory.class)
public class NullLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "com.github.vbauer.herald.logger.empty.NullLogger";
    public static final String FACTORY_CLASS_NAME = LOGGER_CLASS_NAME;
    public static final String FACTORY_METHOD_NAME = "getLogger";


    public NullLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }

}
