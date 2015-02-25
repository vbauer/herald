package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.bean.ClassLogBean;
import com.github.vbauer.herald.bean.LogBean;
import com.github.vbauer.herald.bean.NamedLogBean;
import com.github.vbauer.herald.core.BasicSpringTest;
import com.github.vbauer.herald.logger.ClassLogBeanTest;
import com.github.vbauer.herald.logger.LogBeanTest;
import com.github.vbauer.herald.logger.NamedLogBeanTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class LogBeanPostProcessorTest extends BasicSpringTest {

    @Autowired
    private LogBeanPostProcessor logBeanPostProcessor;


    @Test
    public void testLogBeanPostProcessor() {
        ClassLogBeanTest.check(checkPostProcessor(new ClassLogBean()));
        LogBeanTest.check(checkPostProcessor(new LogBean()));
        NamedLogBeanTest.check(checkPostProcessor(new NamedLogBean()));
    }

    private <T> T checkPostProcessor(final T bean) {
        Assert.isTrue(bean == logBeanPostProcessor.postProcessBeforeInitialization(bean, null));
        Assert.isTrue(bean == logBeanPostProcessor.postProcessAfterInitialization(bean, null));
        return bean;
    }

}
