package com.github.vbauer.herald.ext.spring;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.ext.spring.context.SpringBootTestContext;
import org.junit.Test;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

public class SpringBootRunnerTest extends BasicTest {

    @Test
    public void checkAppRunner() {
        final ApplicationContext context = new SpringApplicationBuilder()
            .headless(true)
            .logStartupInfo(false)
            .bannerMode(Banner.Mode.OFF)
            .sources(SpringBootTestContext.class)
            .run();

        assertThat(context, notNullValue());
    }

}
