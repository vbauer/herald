package com.github.vbauer.herald.logger;

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
        check(logBean);
    }


    public static void check(final LogBean bean) {
        Assert.notNull(LogBean.getStaticJavaUtilLogger());
        Assert.notNull(bean.getJavaUtilLogger());
        Assert.notNull(bean.getCommonsLoggingLogger());
        Assert.notNull(bean.getLogbackLogger());
        Assert.notNull(bean.getSlf4jLogger());
        Assert.notNull(bean.getSlf4jExtLogger());
        Assert.notNull(bean.getLog4jLogger());
        Assert.notNull(bean.getLog4j2Logger());
    }

}
