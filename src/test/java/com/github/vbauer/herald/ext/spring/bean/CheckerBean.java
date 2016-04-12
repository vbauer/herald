package com.github.vbauer.herald.ext.spring.bean;

import com.github.vbauer.herald.ext.spring.LogBeanPostProcessor;
import com.github.vbauer.herald.logger.checker.ClassLogBeanChecker;
import com.github.vbauer.herald.logger.checker.LogBeanChecker;
import com.github.vbauer.herald.logger.checker.NamedLogBeanChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

@Component
public class CheckerBean {

    @Autowired
    private LogBeanPostProcessor logBeanPostProcessor;

    @Autowired
    private ClassLogBean classLogBean;

    @Autowired
    private LogBean logBean;

    @Autowired
    private NamedLogBean namedLogBean;


    public void check() {
        checkBeans(classLogBean, logBean, namedLogBean);
        checkBeans(
            checkPostProcessor(new ClassLogBean()),
            checkPostProcessor(new LogBean()),
            checkPostProcessor(new NamedLogBean())
        );
    }


    private void checkBeans(
        final ClassLogBean classLogBean, final LogBean logBean, final NamedLogBean namedLogBean
    ) {
        ClassLogBeanChecker.check(classLogBean);
        LogBeanChecker.check(logBean);
        NamedLogBeanChecker.check(namedLogBean);
    }

    private <T> T checkPostProcessor(final T bean) {
        Assert.isTrue(bean == logBeanPostProcessor.postProcessBeforeInitialization(bean, null));
        Assert.isTrue(bean == logBeanPostProcessor.postProcessAfterInitialization(bean, null));
        return bean;
    }

}
