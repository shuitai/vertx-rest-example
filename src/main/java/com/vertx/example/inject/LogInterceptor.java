package com.vertx.example.inject;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInterceptor implements MethodInterceptor {

    protected final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        TimeInterval timer = DateUtil.timer();
        timer.start();

        Object result = invocation.proceed();

        long costTime = timer.intervalMs();
        logger.info("cost time: {}", costTime);
        return result;
    }
}
