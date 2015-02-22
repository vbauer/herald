package com.github.vbauer.herald.util;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.logger.LogFactory;
import org.springframework.util.ReflectionUtils;
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


    public static void inject(final Object bean) {
        final Class<?> beanClass = bean.getClass();
        final Collection<LogFactory> logFactories = ServiceLoaderUtils.load(LogFactory.class);

        ReflectionUtils.doWithFields(
                beanClass,
                new ReflectionUtils.FieldCallback() {
                    @Override
                    public void doWith(final Field field) throws IllegalAccessException {
                        inject(bean, field, logFactories);
                    }
                },
                new ReflectionUtils.FieldFilter() {
                    @Override
                    public boolean matches(final Field field) {
                        return field.getAnnotation(Log.class) != null;
                    }
                }
        );
    }


    /*
     * Internal API.
     */

    private static void inject(
        final Object bean, final Field field, final Collection<LogFactory> logFactories
    ) throws IllegalAccessException {
        final boolean isAccessible = field.isAccessible();
        org.springframework.util.ReflectionUtils.makeAccessible(field);

        try {
            final Log annotation = field.getAnnotation(Log.class);
            final String loggerName = annotation.value();
            final Class<?> loggerClass = field.getType();
            final Class<?> beanClass = bean.getClass();

            final LogFactory logFactory = LogFactoryUtils.findCompatible(logFactories, loggerClass);
            if (logFactory == null) {
                throw new UnsupportedOperationException(
                    String.format("Can not find log factory for logger %s", loggerClass)
                );
            }

            final Object logger = createLogger(logFactory, loggerName, beanClass);
            field.set(bean, logger);
        } finally {
            field.setAccessible(isAccessible);
        }
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
