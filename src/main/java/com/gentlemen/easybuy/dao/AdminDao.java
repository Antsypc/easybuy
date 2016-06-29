package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Repository("adminDao")
public interface AdminDao {
    Admin getAdminById(int id);
    Admin getAdminByName(String username);
}
