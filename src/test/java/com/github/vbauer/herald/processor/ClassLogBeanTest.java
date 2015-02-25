package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.bean.ClassLogBean;
import com.github.vbauer.herald.core.BasicSpringTest;
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
        Assert.notNull(classLogBean.getJavaUtilLogger());
        Assert.notNull(classLogBean.getCommonsLoggingLogger());
        Assert.notNull(classLogBean.getLogbackLogger());
        Assert.notNull(classLogBean.getSlf4jLogger());
        Assert.notNull(classLogBean.getSlf4jExtLogger());
        Assert.notNull(classLogBean.getLog4jLogger());
        Assert.notNull(classLogBean.getLog4j2Logger());
        Assert.isTrue(classLogBean.getNotLogger() == ClassLogBean.DEF_NOT_LOGGER_VALUE);
    }

}
