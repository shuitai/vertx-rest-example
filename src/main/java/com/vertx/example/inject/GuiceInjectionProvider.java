package com.vertx.example.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.zandero.rest.injection.InjectionProvider;

import java.util.List;

public class GuiceInjectionProvider implements InjectionProvider {

    private Injector injector;

    public GuiceInjectionProvider(Module[] modules) {
        injector = Guice.createInjector(modules);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object getInstance(Class clazz) {
        return injector.getInstance(clazz);
    }
}

