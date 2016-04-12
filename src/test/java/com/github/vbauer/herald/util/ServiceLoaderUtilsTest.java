package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.LogFactory;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

public class ServiceLoaderUtilsTest extends BasicTest {

    private static final int LOGGERS_COUNT = 11;

    
    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(ServiceLoaderUtils.class);
    }

    @Test
    public void testLoad() throws Exception {
        final Collection<LogFactory> factories = ServiceLoaderUtils.load(LogFactory.class);
        assertThat(factories, hasSize(LOGGERS_COUNT));
    }

}
