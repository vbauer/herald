package com.github.vbauer.herald.exception;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.impl.JavaUtilLogFactory;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

public class HeraldExceptionTest extends BasicTest {

    @Test
    public void testHeraldException() {
        final int modifiers = HeraldException.class.getModifiers();
        assertThat(Modifier.isAbstract(modifiers), equalTo(true));
        assertThat(Modifier.isPublic(modifiers), equalTo(true));

        try {
            throw new HeraldException() {
                private static final long serialVersionUID = 1L;
            };
        } catch (final HeraldException ex) {
            checkMessage(ex);
        }
    }

    @Test
    public void testMissedLogFactoryException() {
        final Class<Logger> loggerClass = Logger.class;
        try {
            throw new MissedLogFactoryException(loggerClass);
        } catch (final MissedLogFactoryException ex) {
            assertThat(loggerClass.isAssignableFrom(ex.getLoggerClass()), equalTo(true));
            checkMessage(ex);
        }
    }

    @Test
    public void testLoggerInstantiationException() {
        final JavaUtilLogFactory logFactory = new JavaUtilLogFactory();
        try {
            throw new LoggerInstantiationException(logFactory);
        } catch (final LoggerInstantiationException ex) {
            assertThat(logFactory, equalTo(ex.getLoggerFactory()));
            checkMessage(ex);
        }
    }


    private void checkMessage(final HeraldException ex) {
        assertThat(ex.getLocalizedMessage(), notNullValue());
        assertThat(ex.getMessage(), notNullValue());
    }

}
