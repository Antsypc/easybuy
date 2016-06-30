package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.CategoryDao;
import com.gentlemen.easybuy.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 得到所有的商品分类信息
 * Created by dengfei on 2016/6/30.
 */
@Service("categoryService")
public class CategoryServer implements CategoryDao {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getCategorys() {
        return categoryDao.getCategorys();
    }
}
