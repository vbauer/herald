package com.github.vbauer.herald.util;

import java.lang.reflect.Method;

/**
 * @author Vladislav Bauer
 */

public final class ReflectionUtils {

    private ReflectionUtils() {
        throw new UnsupportedOperationException();
    }


    public static boolean isAssignableFrom(final String clazz, final Class<?> from) {
        try {
            final Class<?> compatibleLoggerClass = Class.forName(clazz);
            return compatibleLoggerClass.isAssignableFrom(from);
        } catch (final Exception ex) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public  static <I, O> O invokeStatic(final String className, final String methodName, final I argument) {
        try {
            final Class<?> clazz = Class.forName(className);
            final Method method = clazz.getDeclaredMethod(methodName, argument.getClass());

            return (O) org.springframework.util.ReflectionUtils.invokeMethod(method, null, argument);
        } catch (final Exception ex) {
            org.springframework.util.ReflectionUtils.handleReflectionException(ex);
            return null;
        }
    }

}
