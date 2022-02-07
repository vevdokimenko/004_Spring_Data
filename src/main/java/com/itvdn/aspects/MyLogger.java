package com.itvdn.aspects;

import com.itvdn.persistence.model.Auth;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MyLogger {
    private ApplicationContext applicationContext;
    private static Logger LOG = Logger.getLogger(MyLogger.class.getName());
    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        LOG.addHandler(handler);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void beforeMethodInvocation(JoinPoint joinPoint) {
        Auth auth = applicationContext.getBean("auth", Auth.class);
        LOG.info("Authorised: " + auth.isAuth());
        LOG.info("Before method: " + joinPoint.getSignature().toShortString());
    }

    public void afterMethodReturn(JoinPoint joinPoint, Object result) {
        LOG.info(joinPoint.getSignature().getName() + " method of " + joinPoint.getTarget().toString() + " was invoked!");
        LOG.info("Result of method execution : " + result);
    }

    public void afterMethodException(Exception e) {
        LOG.info("Exception: " + e.getMessage());
    }
}
