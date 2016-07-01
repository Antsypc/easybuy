package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.entity.Admin;
import com.gentlemen.easybuy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ants_ypc
 * @version 1.0 6/30/16
 */
@RequestMapping("/api/admin")
@Controller
public class AdminController {

    private static String SUCCESS = "{\"success\":true, \"message\":\"\"}";
    private static String FAILURE = "{\"success\":false, \"message\":\"update error.\"}";

    @Autowired
    private AdminService adminService;

    /**
     * 修改管理员的信息,实质只有修改密码
     *
     * @param admin 包含旧密码和新密码的 admin
     * @param response HttpServletResponse
     * @return 成功返回 {"success":true, "message":""}
     * @throws IOException
     */
    @RequestMapping(path = "/{username}/profile", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String updateAdmin(@RequestBody AdminUpdate admin, HttpServletResponse response) throws IOException {
        Admin admin1 = adminService.getAdminByName(admin.getUsername());
        if (admin1.getPassword().equals(admin.getPassword())) {
            admin1.setPassword(admin.getNewPassword());
            return adminService.updateAdmin(admin1) ? SUCCESS : FAILURE;
        } else {
            response.sendError(401);
            return FAILURE;
        }
    }

    /**
     * 包含 admin 新密码的类
     */
    private static class AdminUpdate {
        private int id;
        private String username;
        private String password;
        private String newPassword;

        public AdminUpdate() {
        }

        public AdminUpdate(int id, String username, String password, String newPassword) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.newPassword = newPassword;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }

        @Override
        public String toString() {
            return "AdminUpdate{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", newPassword='" + newPassword + '\'' +
                    '}';
        }
    }
}
