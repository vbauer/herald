package com.github.vbauer.herald.ext.spring;

import com.github.vbauer.herald.util.LoggerInjector;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Spring {@link BeanPostProcessor} which injects initialized loggers in beans.
 *
 * @author Vladislav Bauer
 */

public class LogBeanPostProcessor implements BeanPostProcessor {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) {
        return LoggerInjector.inject(bean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) {
        return bean;
    }

}
