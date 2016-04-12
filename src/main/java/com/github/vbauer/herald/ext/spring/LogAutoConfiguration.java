package com.github.vbauer.herald.ext.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vladislav Bauer
 */

@Configuration
public class LogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(LogBeanPostProcessor.class)
    public LogBeanPostProcessor logBeanPostProcessor() {
        return new LogBeanPostProcessor();
    }

}
