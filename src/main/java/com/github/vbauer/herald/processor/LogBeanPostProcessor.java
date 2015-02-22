package com.github.vbauer.herald.processor;

import com.github.vbauer.herald.util.LoggerInjector;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Vladislav Bauer
 */

public class LogBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) {
        LoggerInjector.inject(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) {
        return bean;
    }

}
