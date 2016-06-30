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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员和普通用户登录,登出.
 *
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Controller
@RequestMapping("/api/logging/")
public class LoggingController {
    private static String SUCCESS = "{\"success\":true, \"message\":\"\"}";
    private static String FAILURE = "{\"success\":false, \"message\":\"There is no user or wrong password.\"}";

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    /**
     * 管理员登录,POST,JSON.
     *
     * @param admin 需要登录的管理员,根据请求 JSON 映射到 Admin 对象
     * @param session HTTPSession
     * @param response HttpServletResponse
     * @return 登录成功返回 SUCCESS,否则状态码为401
     * @throws IOException
     */
    @RequestMapping(path = "/login/admin", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public String adminLogin(@RequestBody Admin admin, HttpSession session, HttpServletResponse response) throws IOException {
        Admin admin1 = adminService.getAdminByName(admin.getUsername());
        if (admin.getPassword().equals(admin1.getPassword())) {
            session.setAttribute("identity", "admin");
            session.setAttribute("id", admin1.getId());
            session.setAttribute("username", admin1.getUsername());
            response.setHeader("Set-Cookie","logged_in=yes;user_session="+session.getId());
            return SUCCESS;
        } else {
            response.sendError(401);
            return FAILURE;
        }
    }

    /**
     *
     * 普通用户登录,POST,JSON.
     *
     * @param user 需要登录的管理员,根据请求 JSON 映射到 User 对象
     * @param session HTTPSession
     * @param response HttpServletResponse
     * @return 登录成功返回 SUCCESS,否则状态码为401
     * @throws IOException
     */
    @RequestMapping(path = "/login/user", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public String userLogin(@RequestBody User user, HttpSession session, HttpServletResponse response) throws IOException {
        System.out.println(user);
        User user1 = userService.getUserByName(user.getUsername());
        System.out.println(user1);
        if (user.getPassword().equals(user1.getPassword())) {
            session.setAttribute("identity", "user");
            session.setAttribute("id", user1.getId());
            session.setAttribute("username", user1.getUsername());
            response.setHeader("Set-Cookie","logged_in=yes;user_session="+session.getId());
            return SUCCESS;
        } else {
            System.out.println(FAILURE);
            response.sendError(401);
            return FAILURE;
        }
    }

    /**
     * 用户登出
     *
     * @param session HttpSession
     * @return SUCCESS
     */
    @RequestMapping("logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.removeAttribute("identity");
        session.removeAttribute("id");
        session.removeAttribute("username");
        return SUCCESS;
    }

}
