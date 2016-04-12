package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.LogFactory;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

public class LogFactoryUtilsTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(LogFactoryUtils.class);
    }

    @Test
    public void testFindCompatible() {
        assertThat(LogFactoryUtils.findCompatible(null, null), nullValue());
        assertThat(LogFactoryUtils.findCompatible(Collections.<LogFactory>emptyList(), null), nullValue());
        assertThat(LogFactoryUtils.findCompatible(Collections.<LogFactory>emptyList(), Object.class), nullValue());
    }

    @Test
    public void testHasCompatible() {
        assertThat(LogFactoryUtils.hasCompatible(null, null), equalTo(false));
        assertThat(LogFactoryUtils.hasCompatible(Collections.<LogFactory>emptyList(), null), equalTo(false));
        assertThat(LogFactoryUtils.hasCompatible(Collections.<LogFactory>emptyList(), Object.class), equalTo(false));
    }

}
