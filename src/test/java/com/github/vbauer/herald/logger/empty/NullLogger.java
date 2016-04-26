package com.github.vbauer.herald.logger.empty;

/**
 * @author Vladislav Bauer
 */

public final class NullLogger {

    public static NullLogger getLogger(final Class<?> clazz) {
        return null;
    }

    public static NullLogger getLogger(final String name) {
        return null;
    }

}
