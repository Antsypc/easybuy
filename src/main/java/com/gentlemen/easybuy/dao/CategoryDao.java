package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Category;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    Category getById(int id);
    List<Category> getAllCategories();
    Category getParent(Category category);
    int addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(Category category);

    boolean deleteCategory(int id);
}
