package com.github.vbauer.herald.logger;

import com.github.vbauer.herald.ext.spring.bean.ClassLogBean;
import com.github.vbauer.herald.ext.spring.core.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class ClassLogBeanTest extends BasicSpringTest {

    @Autowired
    private ClassLogBean classLogBean;


    @Test
    public void testClassLogBean() {
        check(classLogBean);
    }


    public static void check(final ClassLogBean bean) {
        Assert.notNull(ClassLogBean.getStaticJavaUtilLogger());
        Assert.notNull(bean.getJavaUtilLogger());
        Assert.notNull(bean.getCommonsLoggingLogger());
        Assert.notNull(bean.getLogbackLogger());
        Assert.notNull(bean.getSlf4jLogger());
        Assert.notNull(bean.getSlf4jExtLogger());
        Assert.notNull(bean.getLog4jLogger());
        Assert.notNull(bean.getLog4j2Logger());
        Assert.notNull(bean.getJBossLogger());
        Assert.notNull(bean.getSyslog4jLogger());
        Assert.notNull(bean.getSyslog4jGraylogLogger());
        Assert.notNull(bean.getFluentLogger());
        Assert.notNull(bean.getPlayLogger());
        Assert.isTrue(bean.getNotLogger() == ClassLogBean.DEF_NOT_LOGGER_VALUE);
    }

}
