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

    private static final int REAL_LOGGERS_COUNT = 11;
    private static final int TEST_LOGGERS_COUNT = 1;
    private static final int LOGGERS_COUNT = REAL_LOGGERS_COUNT + TEST_LOGGERS_COUNT;

    
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
