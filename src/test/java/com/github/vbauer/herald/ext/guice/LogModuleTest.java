package com.github.vbauer.herald.ext.guice;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.ext.spring.bean.CheckerBean;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class LogModuleTest extends BasicTest {

    @Test
    public void testBeans() {
        final Injector injector = Guice.createInjector(new LogModule());
        final CheckerBean bean = injector.getInstance(CheckerBean.class);
        bean.checkBeans();
    }

}
