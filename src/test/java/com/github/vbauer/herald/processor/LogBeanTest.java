package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.bean.LogBean;
import com.github.vbauer.herald.core.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class LogBeanTest extends BasicSpringTest {

    @Autowired
    private LogBean logBean;


    @Test
    public void testLogBean() {
        Assert.notNull(logBean.getJavaUtilLogger());
        Assert.notNull(logBean.getCommonsLoggingLogger());
        Assert.notNull(logBean.getLogbackLogger());
        Assert.notNull(logBean.getSlf4jLogger());
        Assert.notNull(logBean.getSlf4jExtLogger());
        Assert.notNull(logBean.getLog4jLogger());
        Assert.notNull(logBean.getLog4j2Logger());
    }

}
