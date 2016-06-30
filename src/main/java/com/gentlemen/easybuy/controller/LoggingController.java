package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.entity.Admin;
import com.gentlemen.easybuy.entity.User;
import com.gentlemen.easybuy.service.AdminService;
import com.gentlemen.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Controller
@RequestMapping("/logging/")
public class LoggingController {
    private static String SUCCESS = "{\"success\":true, \"message\":\"\"}";
    private static String FAILURE = "{\"success\":false, \"message\":\"There is no user or wrong password.\"}";
    private static String USER_EXISTED =
            "{\"success\":false, \"message\":\"该手机号已经被注册.\"}";

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/admin/login", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public String adminLogin(@RequestBody Admin admin, HttpSession session) {
        Admin admin1 = adminService.getAdminByName(admin.getUsername());
        if (admin.getPassword().equals(admin1.getPassword())) {
            session.setAttribute("identity", "admin");
            session.setAttribute("id", admin1.getId());
            session.setAttribute("username", admin1.getUsername());
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    @RequestMapping(path = "/user/login", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public String userLogin(@RequestBody User user, HttpSession session) {
        System.out.println("here");
        User user1 = userService.getUserByName(user.getUsername());
        if (user.getPassword().equals(user1.getPassword())) {
            session.setAttribute("identity", "user");
            session.setAttribute("id", user1.getId());
            session.setAttribute("username", user1.getUsername());
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }

    @RequestMapping("logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.removeAttribute("identity");
        session.removeAttribute("id");
        session.removeAttribute("username");
        return SUCCESS;
    }


//    @RequestMapping(value = "user/register", method = RequestMethod.GET)
//    public String showRegister() {
//        return SUCCESS;
//    }

    /**
     * 用户注册
     * @param user 用户
     * @return
     */
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
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
