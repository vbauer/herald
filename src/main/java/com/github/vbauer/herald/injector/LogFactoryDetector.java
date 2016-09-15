package com.github.vbauer.herald.injector;

import com.github.vbauer.herald.logger.LogFactory;

import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public final class LogFactoryDetector {

    private LogFactoryDetector() {
        throw new UnsupportedOperationException();
    }


    public static boolean hasCompatible(final Collection<LogFactory> factories, final Class<?> loggerClass) {
        return findCompatible(factories, loggerClass) != null;
    }

    public static LogFactory findCompatible(final Collection<LogFactory> factories, final Class<?> loggerClass) {
        if (factories != null) {
            for (final LogFactory factory : factories) {
                if (factory.isCompatible(loggerClass)) {
                    return factory;
                }
            }
        }
        return null;
    }

}
