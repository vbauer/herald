package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public class ServiceLoaderUtilsTest extends BasicTest {

    private static final int LOGGERS_COUNT = 10;

    
    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(ServiceLoaderUtils.class);
    }

    @Test
    public void testLoad() throws Exception {
        final Collection<LogFactory> factories = ServiceLoaderUtils.load(LogFactory.class);
        Assert.assertEquals(LOGGERS_COUNT, factories.size());
    }

}
