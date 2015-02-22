package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

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
        Assert.assertNull(LogFactoryUtils.findCompatible(null, null));
        Assert.assertNull(LogFactoryUtils.findCompatible(Collections.<LogFactory>emptyList(), null));
        Assert.assertNull(LogFactoryUtils.findCompatible(Collections.<LogFactory>emptyList(), Object.class));
    }

}
