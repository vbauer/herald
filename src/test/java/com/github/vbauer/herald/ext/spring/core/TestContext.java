package com.github.vbauer.herald.ext.spring.core;

import com.github.vbauer.herald.ext.spring.LogBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vladislav Bauer
 */

@Configuration
@ComponentScan(basePackages = "com.github.vbauer.herald")
public class TestContext {

    @Bean
    public LogBeanPostProcessor logBeanPostProcessor() {
        return new LogBeanPostProcessor();
    }

}
