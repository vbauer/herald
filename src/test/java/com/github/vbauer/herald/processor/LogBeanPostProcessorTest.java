package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.bean.LogBean;
import com.github.vbauer.herald.bean.NamedLogBean;
import com.github.vbauer.herald.core.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class LogBeanPostProcessorTest extends BasicSpringTest {

    @Autowired
    private LogBean logBean;

    @Autowired
    private NamedLogBean namedLogBean;


    @Test
    public void testLogBean() {
        Assert.notNull(logBean.getJavaUtilLogger());
        Assert.notNull(logBean.getCommonsLoggingLogger());
        Assert.notNull(logBean.getLogbackLogger());
        Assert.notNull(logBean.getSlf4jLogger());
        Assert.notNull(logBean.getLog4jLogger());
    }

    @Test
    public void testNamedLogBean() {
        Assert.notNull(namedLogBean.getJavaUtilLogger());
        Assert.notNull(namedLogBean.getCommonsLoggingLogger());
        Assert.notNull(namedLogBean.getLogbackLogger());
        Assert.notNull(namedLogBean.getSlf4jLogger());
        Assert.notNull(namedLogBean.getLog4jLogger());
    }

}
