package com.github.vbauer.herald.injector;

import com.github.vbauer.herald.core.BasicTest;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

public class LogFactoryDetectorTest extends BasicTest {

    @Test
    public void testConstructorContract() {
        checkUtilConstructorContract(LogFactoryDetector.class);
    }

    @Test
    public void testFindCompatible() {
        assertThat(LogFactoryDetector.findCompatible(null, null), nullValue());
        assertThat(LogFactoryDetector.findCompatible(Collections.emptyList(), null), nullValue());
        assertThat(LogFactoryDetector.findCompatible(Collections.emptyList(), Object.class), nullValue());
    }

    @Test
    public void testHasCompatible() {
        assertThat(LogFactoryDetector.hasCompatible(null, null), equalTo(false));
        assertThat(LogFactoryDetector.hasCompatible(Collections.emptyList(), null), equalTo(false));
        assertThat(LogFactoryDetector.hasCompatible(Collections.emptyList(), Object.class), equalTo(false));
    }

}
