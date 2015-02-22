package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class ReflectionUtilsTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(ReflectionUtils.class);
    }

    @Test
    public void testIsAssignableFrom() {
        final Class<Object> objectClass = Object.class;
        final String objectClassName = objectClass.getName();

        Assert.assertTrue(ReflectionUtils.isAssignableFrom(objectClassName, objectClass));
        Assert.assertFalse(ReflectionUtils.isAssignableFrom(null, objectClass));
        Assert.assertFalse(ReflectionUtils.isAssignableFrom(objectClassName, null));
        Assert.assertFalse(ReflectionUtils.isAssignableFrom(null, null));
    }

    @Test(expected = RuntimeException.class)
    public void testInvokeStatic() {
        ReflectionUtils.invokeStatic(null, null, null);
    }

}
