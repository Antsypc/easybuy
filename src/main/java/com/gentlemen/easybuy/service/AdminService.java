package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.AdminDao;
import com.gentlemen.easybuy.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Service("adminService")
public class AdminService implements AdminDao{

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminById(int id) {
        return adminDao.getAdminById(id);
    }

    @Override
    public Admin getAdminByName(String username) {
        return adminDao.getAdminByName(username);
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }
}
