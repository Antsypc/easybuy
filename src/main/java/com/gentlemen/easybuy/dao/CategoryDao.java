package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Category;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    List<Category> getAllCategories();
    Category getById(int id);
    Category getParent(Category category);
    int addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(Category category);

    boolean deleteCategory(int id);
}
