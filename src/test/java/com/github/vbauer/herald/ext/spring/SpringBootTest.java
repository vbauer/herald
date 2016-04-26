package com.github.vbauer.herald.ext.spring;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.ext.spring.bean.CheckerBean;
import com.github.vbauer.herald.ext.spring.context.SpringBootTestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

@ContextConfiguration(classes = SpringBootTestContext.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringBootTest extends BasicTest {

    @Autowired
    private CheckerBean checkerBean;


    @Test
    public void testAll() {
        checkerBean.checkBeans();
        checkerBean.checkPostProcessor();
    }

    @Test
    public void testAutoConfiguration() {
        final LogAutoConfiguration configuration = new LogAutoConfiguration();
        final LogBeanPostProcessor processor = configuration.logBeanPostProcessor();

        assertThat(processor, notNullValue());
    }

}
