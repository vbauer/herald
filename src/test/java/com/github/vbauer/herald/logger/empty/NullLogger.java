package com.github.vbauer.herald.logger.empty;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("all")
public class NullLogger {

    public static NullLogger getLogger(final Class<?> clazz) {
        return null;
    }

    public static NullLogger getLogger(final String name) {
        return null;
    }

}
