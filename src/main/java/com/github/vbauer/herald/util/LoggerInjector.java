package com.github.vbauer.herald.util;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.logger.LogFactory;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public final class LoggerInjector {

    private LoggerInjector() {
        throw new UnsupportedOperationException();
    }


    public static void inject(final Object... beans) {
        if (beans != null && beans.length > 0) {
            for (final Object bean : beans) {
                inject(bean);
            }
        }
    }

    public static <T> T inject(final T bean) {
        final Class<?> beanClass = bean.getClass();
        final Collection<LogFactory> logFactories = ServiceLoaderUtils.load(LogFactory.class);

        final Field[] declaredFields = beanClass.getDeclaredFields();
        if (!CollectionUtils.isEmpty(declaredFields)) {
            for (final Field field : declaredFields) {
                if (needToInjectLogger(bean, field, logFactories)) {
                    injectLogger(bean, field, logFactories);
                }
            }
        }

        return bean;
    }


    /*
     * Internal API.
     */

    private static boolean needToInjectLogger(
        final Object bean, final Field field, final Collection<LogFactory> logFactories
    ) {
        final boolean isSyntheticField = field.isSynthetic();
        if (!isSyntheticField) {
            final Class<?> beanClass = bean.getClass();
            final boolean hasClassAnnotation = beanClass.getAnnotation(Log.class) != null;

            if (hasClassAnnotation) {
                final Class<?> fieldType = field.getType();
                return LogFactoryUtils.hasCompatible(logFactories, fieldType);
            }
            return field.getAnnotation(Log.class) != null;
        }
        return false;
    }

    private static void injectLogger(
        final Object bean, final Field field, final Collection<LogFactory> logFactories
    ) {
        final boolean isAccessible = field.isAccessible();
        field.setAccessible(true);

        try {
            final Class<?> beanClass = bean.getClass();
            final Log annotation = getAnnotation(beanClass, field);
            final String loggerName = annotation.value();
            final Class<?> loggerClass = field.getType();

            final LogFactory logFactory = LogFactoryUtils.findCompatible(logFactories, loggerClass);
            if (logFactory == null) {
                throw new MissedLogFactoryException(loggerClass, annotation);
            }

            final Object logger = createLogger(logFactory, loggerName, beanClass);
            field.set(bean, logger);
        } catch (final IllegalAccessException ex) {
            ReflectionUtils.handleReflectionException(ex);
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    private static Log getAnnotation(final Class<?> beanClass, final Field field) {
        final Log fieldAnnotation = field.getAnnotation(Log.class);
        return fieldAnnotation == null ? beanClass.getAnnotation(Log.class) : fieldAnnotation;
    }

    private static Object createLogger(final LogFactory logFactory, final String loggerName, final Class<?> beanClass) {
        final String name = loggerName == null ? "" : loggerName.trim();
        if (!name.isEmpty()) {
            return logFactory.createLogger(name);
        } else {
            return logFactory.createLogger(beanClass);
        }
    }

}
