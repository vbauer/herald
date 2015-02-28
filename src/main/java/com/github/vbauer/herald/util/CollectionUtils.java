package com.github.vbauer.herald.util;

import java.util.Collection;

/**
 * @author Vladislav Bauer
 */

public final class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException();
    }


    public static boolean isEmpty(final Collection<?> entries) {
        return size(entries) == 0;
    }

    public static boolean isEmpty(final Object... entries) {
        return size(entries) == 0;
    }

    public static int size(final Collection<?> entries) {
        return entries == null ? 0 : entries.size();
    }

    public static int size(final Object... entries) {
        return entries == null ? 0 : entries.length;
    }

}
