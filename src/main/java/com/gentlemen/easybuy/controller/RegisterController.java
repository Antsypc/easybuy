package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.entity.User;
import com.gentlemen.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 普通用户注册
 *
 * @author ants_ypc
 * @version 1.0 6/30/16
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * 普通用户注册
     *
     * @param user 根据请求 JSON 映射到 User 对象
     * @param response HttpServletResponse
     * @return user JSON
     * @throws Exception
     */
    @RequestMapping(path = "/api/user", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String userRegister(@RequestBody User user, HttpServletResponse response) throws Exception{
        System.out.println(user);
        if (userService.addUser(user)) {
            System.out.println("ok");
            return userService.getUserByName(user.getUsername()).toString().substring(4);
        } else {
            response.sendError(401);
            return "{\"success\":false, \"message\":\"User name has been used or other error.\"}";
        }
    }
}
