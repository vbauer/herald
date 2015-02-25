package com.github.vbauer.herald.util;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.logger.LogFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public final class LoggerInjector {

    private LoggerInjector() {
        throw new UnsupportedOperationException();
    }


    public static <T> T inject(final T bean) {
        final Class<?> beanClass = bean.getClass();
        final Collection<LogFactory> logFactories = ServiceLoaderUtils.load(LogFactory.class);

        ReflectionUtils.doWithFields(
            beanClass,
            new FieldCallback() {
                @Override
                public void doWith(final Field field) throws IllegalAccessException {
                    inject(bean, field, logFactories);
                }
            },
            new FieldFilter() {
                @Override
                public boolean matches(final Field field) {
                    return needToInject(bean, field, logFactories);
                }
            }
        );

        return bean;
    }


    /*
     * Internal API.
     */

    private static boolean needToInject(
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

    private static void inject(
        final Object bean, final Field field, final Collection<LogFactory> logFactories
    ) throws IllegalAccessException {
        final boolean isAccessible = field.isAccessible();
        ReflectionUtils.makeAccessible(field);

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
        } finally {
            field.setAccessible(isAccessible);
        }
    }

    private static Log getAnnotation(final Class<?> beanClass, final Field field) {
        final Log fieldAnnotation = field.getAnnotation(Log.class);
        return fieldAnnotation == null ? beanClass.getAnnotation(Log.class) : fieldAnnotation;
    }

    private static Object createLogger(final LogFactory logFactory, final String loggerName, final Class<?> beanClass) {
        final String name = StringUtils.trimWhitespace(loggerName);
        if (!StringUtils.isEmpty(name)) {
            return logFactory.createLogger(name);
        } else {
            return logFactory.createLogger(beanClass);
        }
    }

}
