package com.github.vbauer.herald.core;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Vladislav Bauer
 */

@ContextConfiguration(classes = TestContext.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BasicSpringTest {
}
