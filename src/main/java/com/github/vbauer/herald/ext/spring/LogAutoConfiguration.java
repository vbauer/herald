package com.github.vbauer.herald.ext.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration component for Spring Boot.
 *
 * @author Vladislav Bauer
 */

@Configuration
public class LogAutoConfiguration {

    /**
     * Create {@link LogBeanPostProcessor} and register it in context if missed.
     *
     * @return create {@link LogBeanPostProcessor}
     */
    @Bean
    @ConditionalOnMissingBean(LogBeanPostProcessor.class)
    public LogBeanPostProcessor logBeanPostProcessor() {
        return new LogBeanPostProcessor();
    }

}
