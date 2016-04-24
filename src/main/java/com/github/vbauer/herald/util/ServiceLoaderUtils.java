package com.github.vbauer.herald.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Vladislav Bauer
 */

public final class ServiceLoaderUtils {

    private ServiceLoaderUtils() {
        throw new UnsupportedOperationException();
    }


    public static <T> Collection<T> load(final Class<T> beanClass) {
        final ServiceLoader<T> serviceLoader = ServiceLoader.load(beanClass);
        final Iterator<T> iterator = serviceLoader.iterator();

        final List<T> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

}
