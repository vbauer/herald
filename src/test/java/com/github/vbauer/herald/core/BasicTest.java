package com.github.vbauer.herald.core;

import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author Vladislav Bauer
 */

@RunWith(BlockJUnit4ClassRunner.class)
public abstract class BasicTest {

    protected final void checkUtilConstructorContract(final Class<?> utilClass) throws Exception {
        PrivateConstructorChecker
            .forClass(utilClass)
            .expectedTypeOfException(UnsupportedOperationException.class)
            .check();
    }

}
