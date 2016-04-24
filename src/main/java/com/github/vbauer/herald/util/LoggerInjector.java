package com.github.vbauer.herald.util;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.exception.LoggerInstantiationException;
import com.github.vbauer.herald.logger.LogFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vladislav Bauer
 */

public final class LoggerInjector {

    private LoggerInjector() {
        throw new UnsupportedOperationException();
    }


    public static Collection<Object> inject(final Object... beans) {
        final List<Object> result = new ArrayList<>();

        if (beans != null) {
            for (final Object bean : beans) {
                result.add(inject(bean));
            }
        }

        return result;
    }

    public static <T> T inject(final T bean) {
        final Class<?> beanClass = bean.getClass();
        final Collection<LogFactory> logFactories = ServiceLoaderUtils.load(LogFactory.class);

        final Field[] declaredFields = beanClass.getDeclaredFields();
        for (final Field field : declaredFields) {
            if (needToInjectLogger(bean, field, logFactories)) {
                injectLogger(bean, field, logFactories);
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
            return needToInjectLogger(beanClass, logFactories, field);
        }
        return false;
    }

    private static boolean needToInjectLogger(
        final Class<?> beanClass, final Collection<LogFactory> logFactories, final Field field
    ) {
        final boolean hasAnnotation = beanClass.getAnnotation(Log.class) != null;
        if (hasAnnotation) {
            final Class<?> fieldType = field.getType();
            return LogFactoryUtils.hasCompatible(logFactories, fieldType);
        }
        return field.getAnnotation(Log.class) != null;
    }

    private static void injectLogger(
        final Object bean, final Field field, final Collection<LogFactory> logFactories
    ) {
        final boolean isAccessible = field.isAccessible();
        field.setAccessible(true);

        // Read context parameters.
        final Class<?> beanClass = bean.getClass();
        final Class<?> loggerClass = field.getType();
        final Log annotation = ReflectionUtils.findAnnotation(Log.class, beanClass, field);

        final boolean required = annotation.required();
        final String loggerName = annotation.value();

        try {
            // Find corresponding logger factory.
            final LogFactory logFactory = LogFactoryUtils.findCompatible(logFactories, loggerClass);
            if (logFactory == null) {
                throw new MissedLogFactoryException(loggerClass);
            }

            // Create logger
            final Object logger = createLogger(logFactory, loggerName, beanClass);
            if (logger == null) {
                throw new LoggerInstantiationException(logFactory);
            }

            field.set(bean, logger);
        } catch (final Throwable ex) {
            if (required) {
                ReflectionUtils.handleReflectionException(ex);
            }
        } finally {
            try {
                field.setAccessible(isAccessible);
            } catch (final SecurityException ignored) {
                // Ignored.
            }
        }
    }

    private static Object createLogger(final LogFactory logFactory, final String loggerName, final Class<?> beanClass) {
        if (!loggerName.isEmpty()) {
            return logFactory.createLogger(loggerName);
        } else {
            return logFactory.createLogger(beanClass);
        }
    }

}
