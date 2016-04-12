package com.github.vbauer.herald.ext.spring;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.ext.spring.bean.CheckerBean;
import com.github.vbauer.herald.ext.spring.core.context.SpringBootTestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        checkerBean.check();
    }

}
