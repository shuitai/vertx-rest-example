package com.vertx.example.module;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.vertx.example.annotation.AuditLog;
import com.vertx.example.inject.LogInterceptor;

public class AdminModule extends AbstractModule {

    @Override
    protected void configure() {
        LogInterceptor logInterceptor = new LogInterceptor();
        requestInjection(logInterceptor);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(AuditLog.class), logInterceptor);
    }
}
