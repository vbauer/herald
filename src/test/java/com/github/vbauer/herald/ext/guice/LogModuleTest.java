package com.github.vbauer.herald.ext.guice;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.ext.spring.bean.ClassLogBean;
import com.github.vbauer.herald.ext.spring.bean.LogBean;
import com.github.vbauer.herald.ext.spring.bean.NamedLogBean;
import com.github.vbauer.herald.logger.bean.ClassLogBeanTest;
import com.github.vbauer.herald.logger.bean.LogBeanTest;
import com.github.vbauer.herald.logger.bean.NamedLogBeanTest;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class LogModuleTest extends BasicTest {

    @Test
    public void testClassLogBean() {
        ClassLogBeanTest.check(initAndGetBean(ClassLogBean.class));
    }

    @Test
    public void testLogBean() {
        LogBeanTest.check(initAndGetBean(LogBean.class));
    }

    @Test
    public void testNamedLogBean() {
        NamedLogBeanTest.check(initAndGetBean(NamedLogBean.class));
    }


    private <T> T initAndGetBean(final Class<T> type) {
        final Injector injector = Guice.createInjector(new LogModule());
        return injector.getInstance(type);
    }

}
