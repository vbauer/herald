package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.LogFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class ServiceLoaderUtilsTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(ServiceLoaderUtils.class);
    }

    @Test
    public void testLoad() throws Exception {
        Assert.assertNotNull(ServiceLoaderUtils.load(LogFactory.class));
    }

}
