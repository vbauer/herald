package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Vladislav Bauer
 */

public class CollectionUtilsTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(CollectionUtils.class);
    }

    @Test
    public void testSizeArray() {
        Assert.assertEquals(0, CollectionUtils.size((Object[]) null));
        Assert.assertEquals(0, CollectionUtils.size());
        Assert.assertEquals(1, CollectionUtils.size(1));
    }

    @Test
    public void testSizeCollection() {
        Assert.assertEquals(0, CollectionUtils.size((Collection<?>) null));
        Assert.assertEquals(0, CollectionUtils.size(Collections.emptyList()));
        Assert.assertEquals(0, CollectionUtils.size(Collections.emptySet()));
        Assert.assertEquals(1, CollectionUtils.size(Collections.singleton(1)));
        Assert.assertEquals(1, CollectionUtils.size(Collections.singletonList(1)));
    }

    @Test
    public void testIsEmptyArray() {
        Assert.assertTrue(CollectionUtils.isEmpty((Object[]) null));
        Assert.assertTrue(CollectionUtils.isEmpty());
        Assert.assertFalse(CollectionUtils.isEmpty(new Object()));
        Assert.assertFalse(CollectionUtils.isEmpty(new Object(), new Object()));
    }

    @Test
    public void testIsEmptyCollection() {
        Assert.assertTrue(CollectionUtils.isEmpty((Collection<?>) null));
        Assert.assertTrue(CollectionUtils.isEmpty(Collections.emptyList()));
        Assert.assertTrue(CollectionUtils.isEmpty(Collections.emptySet()));
        Assert.assertFalse(CollectionUtils.isEmpty(Collections.singleton(1)));
        Assert.assertFalse(CollectionUtils.isEmpty(Collections.singletonList(1)));
    }

}
