package com.github.vbauer.herald.ext.spring.context;

import com.github.vbauer.herald.ext.spring.LogAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vladislav Bauer
 */

@Configuration
@ComponentScan
@ImportAutoConfiguration(LogAutoConfiguration.class)
public class SpringBootTestContext {
}
