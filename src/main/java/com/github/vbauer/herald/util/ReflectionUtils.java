package com.github.vbauer.herald.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Vladislav Bauer
 */

public final class ReflectionUtils {

    private ReflectionUtils() {
        throw new UnsupportedOperationException();
    }


    public static boolean isAssignableFrom(final String className, final Class<?> from) {
        try {
            final Class<?> clazz = Class.forName(className);
            return clazz.isAssignableFrom(from);
        } catch (final Exception ex) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public  static <I, O> O invokeStatic(final String className, final String methodName, final I argument) {
        try {
            final Class<?> clazz = Class.forName(className);
            final Class<?> argumentClass = argument.getClass();

            final Method method = clazz.getDeclaredMethod(methodName, argumentClass);
            return (O) method.invoke(null, argument);
        } catch (final Exception ex) {
            return handleReflectionException(ex);
        }
    }

    public static <T> T handleReflectionException(final Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        } else if (ex instanceof Error) {
            throw (Error) ex;
        }
        throw new RuntimeException(ex);
    }

    public static <T extends Annotation> T findAnnotation(
        final Class<T> annotationClass, final Class<?> beanClass, final Field field
    ) {
        final T fieldAnnotation = field.getAnnotation(annotationClass);
        return fieldAnnotation == null ? beanClass.getAnnotation(annotationClass) : fieldAnnotation;
    }

}
