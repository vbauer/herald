package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.bean.NamedLogBean;
import com.github.vbauer.herald.core.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class NamedLogBeanTest extends BasicSpringTest {

    @Autowired
    private NamedLogBean namedLogBean;


    @Test
    public void testNamedLogBean() {
        Assert.notNull(namedLogBean.getJavaUtilLogger());
        Assert.notNull(namedLogBean.getCommonsLoggingLogger());
        Assert.notNull(namedLogBean.getLogbackLogger());
        Assert.notNull(namedLogBean.getSlf4jLogger());
        Assert.notNull(namedLogBean.getSlf4jExtLogger());
        Assert.notNull(namedLogBean.getLog4jLogger());
        Assert.notNull(namedLogBean.getLog4j2Logger());
    }

}
