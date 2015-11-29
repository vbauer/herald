package com.github.vbauer.herald.exception;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.impl.JavaUtilLogFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.logging.Logger;

/**
 * @author Vladislav Bauer
 */

public class HeraldExceptionTest extends BasicTest {

    @Test
    public void testHeraldException() {
        final int modifiers = HeraldException.class.getModifiers();
        Assert.assertTrue(Modifier.isAbstract(modifiers));
        Assert.assertTrue(Modifier.isPublic(modifiers));

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
            Assert.assertTrue(loggerClass.isAssignableFrom(ex.getLoggerClass()));
            checkMessage(ex);
        }
    }

    @Test
    public void testLoggerInstantiationException() {
        final JavaUtilLogFactory logFactory = new JavaUtilLogFactory();
        try {
            throw new LoggerInstantiationException(logFactory);
        } catch (final LoggerInstantiationException ex) {
            Assert.assertEquals(logFactory, ex.getLoggerFactory());
            checkMessage(ex);
        }
    }


    private void checkMessage(final HeraldException ex) {
        Assert.assertNotNull(ex.getLocalizedMessage());
        Assert.assertNotNull(ex.getMessage());
    }

}
