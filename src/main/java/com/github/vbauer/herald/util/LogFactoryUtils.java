package com.github.vbauer.herald.util;

import com.github.vbauer.herald.logger.LogFactory;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public final class LogFactoryUtils {

    private LogFactoryUtils() {
        throw new UnsupportedOperationException();
    }

    public static LogFactory findCompatible(final Collection<LogFactory> factories, final Class<?> loggerClass) {
        if (!CollectionUtils.isEmpty(factories)) {
            for (final LogFactory factory : factories) {
                if (factory.isCompatible(loggerClass)) {
                    return factory;
                }
            }
        }
        return null;
    }

}
