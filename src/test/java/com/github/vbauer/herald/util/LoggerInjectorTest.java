package com.github.vbauer.herald.util;

import com.github.vbauer.herald.bean.ClassLogBean;
import com.github.vbauer.herald.bean.IncorrectLogBean;
import com.github.vbauer.herald.bean.LogBean;
import com.github.vbauer.herald.bean.NamedLogBean;
import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.logger.ClassLogBeanTest;
import com.github.vbauer.herald.logger.LogBeanTest;
import com.github.vbauer.herald.logger.NamedLogBeanTest;
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

    @Test
    public void testNoOneLogger() {
        Assert.assertNotNull(LoggerInjector.inject(new IncorrectLogBean.EmptyTestClass()));
    }

    @Test
    public void testFewBeans() {
        final ClassLogBean classLogBean = new ClassLogBean();
        final LogBean logBean = new LogBean();
        final NamedLogBean namedLogBean = new NamedLogBean();

        Assert.assertEquals(3, LoggerInjector.inject(classLogBean, logBean, namedLogBean).size());

        ClassLogBeanTest.check(classLogBean);
        LogBeanTest.check(logBean);
        NamedLogBeanTest.check(namedLogBean);
    }

    @Test
    public void testZeroBeans() {
        Assert.assertTrue(LoggerInjector.inject().isEmpty());
    }

}
