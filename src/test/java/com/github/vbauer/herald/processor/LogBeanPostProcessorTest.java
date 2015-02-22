package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.bean.TestBean;
import com.github.vbauer.herald.core.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class LogBeanPostProcessorTest extends BasicSpringTest {

    @Autowired
    private TestBean testBean;


    @Test
    public void testProcessor() {
        Assert.notNull(testBean.getJavaUtilLogger());
        Assert.notNull(testBean.getCommonsLoggingLogger());
    }


}
