package com.github.vbauer.herald.ext.guice;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.ext.spring.bean.ClassLogBean;
import com.github.vbauer.herald.ext.spring.bean.LogBean;
import com.github.vbauer.herald.ext.spring.bean.NamedLogBean;
import com.github.vbauer.herald.logger.checker.ClassLogBeanChecker;
import com.github.vbauer.herald.logger.checker.LogBeanChecker;
import com.github.vbauer.herald.logger.checker.NamedLogBeanChecker;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class LogModuleTest extends BasicTest {

    @Test
    public void testClassLogBean() {
        ClassLogBeanChecker.check(initAndGetBean(ClassLogBean.class));
    }

    @Test
    public void testLogBean() {
        LogBeanChecker.check(initAndGetBean(LogBean.class));
    }

    @Test
    public void testNamedLogBean() {
        NamedLogBeanChecker.check(initAndGetBean(NamedLogBean.class));
    }


    private <T> T initAndGetBean(final Class<T> type) {
        final Injector injector = Guice.createInjector(new LogModule());
        return injector.getInstance(type);
    }

}
