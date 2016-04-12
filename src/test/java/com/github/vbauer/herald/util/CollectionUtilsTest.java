package com.github.vbauer.herald.util;

import com.github.vbauer.herald.core.BasicTest;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
        assertThat(CollectionUtils.size((Object[]) null), equalTo(0));
        assertThat(CollectionUtils.size(), equalTo(0));
        assertThat(CollectionUtils.size(1), equalTo(1));
    }

    @Test
    public void testSizeCollection() {
        assertThat(CollectionUtils.size((Collection<?>) null), equalTo(0));
        assertThat(CollectionUtils.size(Collections.emptyList()), equalTo(0));
        assertThat(CollectionUtils.size(Collections.emptySet()), equalTo(0));
        assertThat(CollectionUtils.size(Collections.singleton(1)), equalTo(1));
        assertThat(CollectionUtils.size(Collections.singletonList(1)), equalTo(1));
    }

    @Test
    public void testIsEmptyArray() {
        assertThat(CollectionUtils.isEmpty((Object[]) null), equalTo(true));
        assertThat(CollectionUtils.isEmpty(), equalTo(true));
        assertThat(CollectionUtils.isEmpty(new Object()), equalTo(false));
        assertThat(CollectionUtils.isEmpty(new Object(), new Object()), equalTo(false));
    }

    @Test
    public void testIsEmptyCollection() {
        assertThat(CollectionUtils.isEmpty((Collection<?>) null), equalTo(true));
        assertThat(CollectionUtils.isEmpty(Collections.emptyList()), equalTo(true));
        assertThat(CollectionUtils.isEmpty(Collections.emptySet()), equalTo(true));
        assertThat(CollectionUtils.isEmpty(Collections.singleton(1)), equalTo(false));
        assertThat(CollectionUtils.isEmpty(Collections.singletonList(1)), equalTo(false));
    }

}
