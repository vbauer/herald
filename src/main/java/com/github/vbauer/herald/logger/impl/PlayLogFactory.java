package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
public class PlayLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "play.Logger$ALogger";
    public static final String FACTORY_CLASS_NAME = "play.Logger";
    public static final String FACTORY_METHOD_NAME = "of";


    public PlayLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }

}
