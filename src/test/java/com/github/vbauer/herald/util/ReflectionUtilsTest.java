package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import org.junit.Test;

import static java.lang.String.valueOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

        assertThat(ReflectionUtils.isAssignableFrom("some.strange.missed.Class", objectClass), equalTo(false));
        assertThat(ReflectionUtils.isAssignableFrom(objectClassName, objectClass), equalTo(true));
        assertThat(ReflectionUtils.isAssignableFrom(null, objectClass), equalTo(false));
        assertThat(ReflectionUtils.isAssignableFrom(objectClassName, null), equalTo(false));
        assertThat(ReflectionUtils.isAssignableFrom(null, null), equalTo(false));
    }

    @Test(expected = RuntimeException.class)
    public void testInvokeStatic() {
        fail(valueOf(ReflectionUtils.invokeStatic(null, null, null)));
    }

    @Test(expected = RuntimeException.class)
    public void testHandleReflectionException() {
        fail(valueOf(ReflectionUtils.handleReflectionException(new Exception())));
    }

    @Test(expected = RuntimeException.class)
    public void testHandleReflectionRuntimeException() {
        fail(valueOf(ReflectionUtils.handleReflectionException(new RuntimeException())));
    }

    @Test(expected = Error.class)
    public void testHandleReflectionError() {
        fail(valueOf(ReflectionUtils.handleReflectionException(new Error())));
    }

    @Test
    public void testSetAccessible() {
        assertThat(ReflectionUtils.setAccessible(null, true), equalTo(false));
        assertThat(ReflectionUtils.setAccessible(Object.class.getConstructors()[0], true), equalTo(true));
    }

}
