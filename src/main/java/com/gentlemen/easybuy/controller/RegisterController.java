package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.entity.User;
import com.gentlemen.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wang_zhao on 2016/6/30.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private static String SUCCESS =
            "{\"success\":true, \"message\":\"\"}";
    private static String USER_EXISTED =
            "{\"success\":false, \"message\":\"该手机号已经注册.\"}";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showRegister() {
        return "test-register";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String doRegister(User user) {
        System.out.println("register");
        if (userService.checkUserByPhone(user.getPhone()) == 0) {
            userService.createUser(user);
            return SUCCESS;
        }
        else
            return USER_EXISTED;
    }
}
