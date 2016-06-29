package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/{username}")
    @ResponseBody
    public String getAdmin(@PathVariable String username) {
        System.out.println("admin");
        return adminService.getAdminByName(username).toString();
    }
}
