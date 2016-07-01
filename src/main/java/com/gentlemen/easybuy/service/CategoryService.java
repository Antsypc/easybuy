package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.CategoryDao;
import com.gentlemen.easybuy.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 6/30/16
 */
@Service("categoryService")
public class CategoryService implements CategoryDao {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public Category getById(int id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category getParent(Category category) {
        return categoryDao.getParent(category);
    }

    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryDao.deleteCategory(id);
    }

    @Override
    public boolean deleteCategory(Category category) {
        return categoryDao.deleteCategory(category);
    }
}
