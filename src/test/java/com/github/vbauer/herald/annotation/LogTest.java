package com.github.vbauer.herald.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for {@link Log}.
 *
 * @author Vladislav Bauer
 */
public class LogTest {

    @Test
    public void testContract() {
        final String value = "TEST_VALUE";
        final boolean required = true;
        final Log log = createLogObject(value, required);

        assertThat(log.value(), equalTo(value));
        assertThat(log.required(), equalTo(required));
    }


    private Log createLogObject(final String value, final boolean required) {
        return new Log() {
            /**
             * {@inheritDoc}
             */
            @Override
            public Class<? extends Annotation> annotationType() {
                return Log.class;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public String value() {
                return value;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean required() {
                return required;
            }
        };
    }

}
