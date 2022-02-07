package com.itvdn.aspects;

import com.itvdn.persistence.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class CheckAuthAspect {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public void checkAuth() throws Exception {
        Auth auth = context.getBean("auth", Auth.class);
        if (!auth.isAuth()) {
            throw new Exception("User is not authorized!");
        }
    }
}
