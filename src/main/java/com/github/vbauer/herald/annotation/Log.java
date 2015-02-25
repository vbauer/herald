package com.github.vbauer.herald.annotation;

import java.lang.annotation.*;

/**
 * Log annotation must be used on logger fields to automatically inject logger instance.
 * It is also possible to put this annotation on class to inject loggers in all suitable fields.
 *
 * @author Vladislav Bauer
 */

@Documented
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * Setup logger name, if it's empty, then class name will be used.
     * @return logger name
     */
    String value() default "";

}
