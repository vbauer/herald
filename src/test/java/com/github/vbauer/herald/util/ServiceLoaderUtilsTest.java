package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class ServiceLoaderUtilsTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(ServiceLoaderUtils.class);
    }

}
