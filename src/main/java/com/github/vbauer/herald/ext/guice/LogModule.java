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

    private final Matcher<Object> typeMatcher;


    public LogModule() {
        this(Matchers.any());
    }

    public LogModule(final Matcher<Object> typeMatcher) {
        this.typeMatcher = typeMatcher;
    }


    @Override
    protected void configure() {
        bindListener(typeMatcher, createTypeListener());
    }


    private TypeListener createTypeListener() {
        return new TypeListener() {
            @Override
            public <I> void hear(final TypeLiteral<I> typeLiteral, final TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>() {

                    @Override
                    public void afterInjection(final I injectee) {
                        LoggerInjector.inject(injectee);
                    }
                });
            }
        };
    }

}
