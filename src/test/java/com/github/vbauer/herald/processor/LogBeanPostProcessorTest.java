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
        final ClassLogBean classLogBean = new ClassLogBean();
        Assert.notNull(logBeanPostProcessor.postProcessBeforeInitialization(classLogBean, null));
        Assert.notNull(logBeanPostProcessor.postProcessAfterInitialization(classLogBean, null));
        ClassLogBeanTest.check(classLogBean);

        final LogBean logBean = new LogBean();
        Assert.notNull(logBeanPostProcessor.postProcessBeforeInitialization(logBean, null));
        Assert.notNull(logBeanPostProcessor.postProcessAfterInitialization(logBean, null));
        LogBeanTest.check(logBean);

        final NamedLogBean namedLogBean = new NamedLogBean();
        Assert.notNull(logBeanPostProcessor.postProcessBeforeInitialization(namedLogBean, null));
        Assert.notNull(logBeanPostProcessor.postProcessAfterInitialization(namedLogBean, null));
        NamedLogBeanTest.check(namedLogBean);
    }

}
