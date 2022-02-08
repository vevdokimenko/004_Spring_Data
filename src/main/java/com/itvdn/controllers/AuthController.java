package com.itvdn.controllers;

import com.itvdn.persistence.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

//    @GetMapping(value = "login")
//    public ModelAndView login(ModelAndView modelAndView) {
//        Auth auth = context.getBean("auth", Auth.class);
//        auth.setAuth(true);
//        modelAndView.setViewName("views/auth/login");
//        return modelAndView;
//    }

//    @GetMapping(value = "logout")
//    public ModelAndView logout(ModelAndView modelAndView) {
//        Auth auth = context.getBean("auth", Auth.class);
//        auth.setAuth(false);
//        modelAndView.setViewName("views/auth/logout");
//        return modelAndView;
//    }

    @GetMapping(value = "hello")
    public String hello() {
        return "index";
    }
}
