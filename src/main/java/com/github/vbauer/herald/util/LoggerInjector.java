package com.github.vbauer.herald.util;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.exception.LoggerInstantiationException;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.logger.LogFactory;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public final class LoggerInjector {

    private static final Collection<LogFactory> LOG_FACTORIES =
        ServiceLoaderUtils.load(LogFactory.class);


    private LoggerInjector() {
        throw new UnsupportedOperationException();
    }


    public static void inject(final Object... beans) {
        if (beans != null) {
            for (final Object bean : beans) {
                inject(bean);
            }
        }
    }

    public static <T> T inject(final T bean) {
        final Class<?> beanClass = bean.getClass();
        final Field[] declaredFields = beanClass.getDeclaredFields();

        for (final Field field : declaredFields) {
            if (needToInjectLogger(beanClass, field)) {
                injectLogger(bean, field);
            }
        }
        return bean;
    }


    /*
     * Internal API.
     */

    private static boolean needToInjectLogger(final Class<?> beanClass, final Field field) {
        final boolean hasAnnotation = beanClass.getAnnotation(Log.class) != null;
        if (hasAnnotation) {
            final Class<?> fieldType = field.getType();
            return LogFactoryUtils.hasCompatible(LOG_FACTORIES, fieldType);
        }
        return field.getAnnotation(Log.class) != null;
    }

    private static void injectLogger(final Object bean, final Field field) {
        final boolean isAccessible = field.isAccessible();
        ReflectionUtils.setAccessible(field, true);

        // Read context parameters.
        final Class<?> beanClass = bean.getClass();
        final Class<?> loggerClass = field.getType();
        final Log annotation = ReflectionUtils.findAnnotation(Log.class, beanClass, field);

        final boolean required = annotation.required();
        final String loggerName = annotation.value();

        try {
            final Object logger = createLogger(beanClass, loggerClass, loggerName);
            field.set(bean, logger);
        } catch (final Throwable ex) {
            if (required) {
                ReflectionUtils.handleReflectionException(ex);
            }
        } finally {
            ReflectionUtils.setAccessible(field, isAccessible);
        }
    }

    private static Object createLogger(
        final Class<?> beanClass, final Class<?> loggerClass, final String loggerName
    ) {
        // Find corresponding logger factory.
        final LogFactory logFactory =
            LogFactoryUtils.findCompatible(LOG_FACTORIES, loggerClass);

        if (logFactory == null) {
            throw new MissedLogFactoryException(loggerClass);
        }

        // Create logger.
        final Object logger = !loggerName.isEmpty()
            ? logFactory.createLogger(loggerName) : logFactory.createLogger(beanClass);

        if (logger == null) {
            throw new LoggerInstantiationException(logFactory);
        }
        return logger;
    }

}
