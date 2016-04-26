package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.ext.spring.bean.CheckerBean;
import com.github.vbauer.herald.ext.spring.bean.ClassLogBean;
import com.github.vbauer.herald.ext.spring.bean.IncorrectLogBean;
import com.github.vbauer.herald.ext.spring.bean.LogBean;
import com.github.vbauer.herald.ext.spring.bean.NamedLogBean;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vadislav Bauer
 */

public class LoggerInjectorTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(LoggerInjector.class);
    }

    @Test(expected = MissedLogFactoryException.class)
    public void testIncorrectLogger() {
        Assert.fail(LoggerInjector.inject(new IncorrectLogBean()).toString());
    }

    @Test
    public void testSynthetic() {
        final IncorrectLogBean bean = new IncorrectLogBean();
        final IncorrectLogBean.SyntheticTestClass syntheticBean = bean.new SyntheticTestClass();

        assertThat(LoggerInjector.inject(syntheticBean), notNullValue());
    }

    @Test
    public void testNoOneLogger() {
        final IncorrectLogBean.EmptyTestClass bean = new IncorrectLogBean.EmptyTestClass();

        assertThat(LoggerInjector.inject(bean), notNullValue());
    }

    @Test
    public void testFewBeans() {
        final ClassLogBean classLogBean = new ClassLogBean();
        final LogBean logBean = new LogBean();
        final NamedLogBean namedLogBean = new NamedLogBean();

        LoggerInjector.inject();
        LoggerInjector.inject((Object[]) null);
        LoggerInjector.inject(classLogBean, logBean, namedLogBean);

        final CheckerBean checkerBean = new CheckerBean(classLogBean, logBean, namedLogBean);
        checkerBean.checkBeans();
    }

}
