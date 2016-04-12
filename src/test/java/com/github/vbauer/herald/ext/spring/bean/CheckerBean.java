package com.github.vbauer.herald.ext.spring.bean;

import com.github.vbauer.herald.ext.spring.LogBeanPostProcessor;
import com.github.vbauer.herald.logger.checker.ClassLogBeanChecker;
import com.github.vbauer.herald.logger.checker.LogBeanChecker;
import com.github.vbauer.herald.logger.checker.NamedLogBeanChecker;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

@Component
public class CheckerBean {

    @Inject
    private LogBeanPostProcessor logBeanPostProcessor;

    private final ClassLogBean classLogBean;
    private final LogBean logBean;
    private final NamedLogBean namedLogBean;


    @Inject
    public CheckerBean(
        final ClassLogBean classLogBean,
        final LogBean logBean,
        final NamedLogBean namedLogBean
    ) {
        this.classLogBean = classLogBean;
        this.logBean = logBean;
        this.namedLogBean = namedLogBean;
    }


    public void checkBeans() {
        checkBeans(classLogBean, logBean, namedLogBean);
    }

    public void checkPostProcessor() {
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

    @SuppressWarnings("unchecked")
    private <T> T checkPostProcessor(final T bean) {
        final T before = (T) logBeanPostProcessor.postProcessBeforeInitialization(bean, null);
        assertThat(before, equalTo(bean));

        final T after = (T) logBeanPostProcessor.postProcessAfterInitialization(bean, null);
        assertThat(after, equalTo(bean));

        return bean;
    }

}
