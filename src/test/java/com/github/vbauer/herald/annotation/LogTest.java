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

    private static final String TEST_VALUE = "TEST_VALUE";
    private static final boolean TEST_REQUIRED = true;


    @Test
    public void testContract() {
        final Log log = createLogObject();

        assertThat(log.value(), equalTo(TEST_VALUE));
        assertThat(log.required(), equalTo(TEST_REQUIRED));
    }


    private Log createLogObject() {
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
                return TEST_VALUE;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean required() {
                return TEST_REQUIRED;
            }
        };
    }

}
