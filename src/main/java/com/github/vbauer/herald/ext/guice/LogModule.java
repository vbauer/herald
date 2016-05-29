package com.github.vbauer.herald.ext.guice;

import com.github.vbauer.herald.util.LoggerInjector;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * @author Vladislav Bauer
 */

public class LogModule extends AbstractModule {

    private static final InjectionListener<Object> INJECTION_LISTENER = createInjectionListener();

    private final Matcher<Object> typeMatcher;


    public LogModule() {
        this(Matchers.any());
    }

    public LogModule(final Matcher<Object> typeMatcher) {
        this.typeMatcher = typeMatcher;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure() {
        bindListener(typeMatcher, createTypeListener());
    }


    private TypeListener createTypeListener() {
        return new TypeListener() {
            @Override
            public <I> void hear(final TypeLiteral<I> typeLiteral, final TypeEncounter<I> typeEncounter) {
                typeEncounter.register(INJECTION_LISTENER);
            }
        };
    }

    private static InjectionListener<Object> createInjectionListener() {
        return new InjectionListener<Object>() {
            @Override
            public void afterInjection(final Object bean) {
                LoggerInjector.inject(bean);
            }
        };
    }

}
