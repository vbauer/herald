package com.github.vbauer.herald.ext.spring;

import com.github.vbauer.herald.util.LoggerInjector;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Vladislav Bauer
 */

public class LogBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) {
        return LoggerInjector.inject(bean);
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) {
        return bean;
    }

}
