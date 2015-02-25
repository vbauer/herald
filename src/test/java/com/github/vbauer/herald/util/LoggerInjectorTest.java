package com.github.vbauer.herald.util;

import com.github.vbauer.herald.bean.IncorrectLogBean;
import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vadislav Bauer
 */

public class LoggerInjectorTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(LoggerInjector.class);
    }

    @Test
    public void testIncorrectLogger() {
        try {
            Assert.fail(LoggerInjector.inject(new IncorrectLogBean()).toString());
        } catch (final MissedLogFactoryException ex) {
            Assert.assertNotNull(ex.getLogAnnotation());
            Assert.assertNotNull(ex.getLoggerClass());
            Assert.assertNotNull(ex.getMessage());
        }
    }

    @Test
    public void testSynthetic() {
        final IncorrectLogBean bean = new IncorrectLogBean();
        Assert.assertNotNull(LoggerInjector.inject(bean.new SyntheticTestClass()));
    }

}
