package com.gentlemen.easybuy.service; 

import com.gentlemen.easybuy.entity.Category;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/** 
 * CategoryService Tester. 
 * 
 * @author <Authors name> 
 * @since <pre>Jun 30, 2016</pre> 
 * @version 1.0 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring.xml"})
public class CategoryServiceTest {

    private CategoryService categoryService;

    @Before
    public void before() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config/spring.xml"});
        categoryService = (CategoryService) ac.getBean("categoryService");
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
     * Method: getAllCategories() 
     */ 
    @Test
    public void testGetAllCategories() throws Exception { 
    } 
    
    /** 
     * Method: getById() 
     */ 
    @Test
    public void testGetById() throws Exception { 
    } 
    
    /** 
     * Method: getParent(Category category) 
     */ 
    @Test
    public void testGetParent() throws Exception {
        Category category = categoryService.getById(1);
        System.out.println(category);
    } 
    
    /** 
     * Method: addCategory(Category category) 
     */ 
    @Test
    public void testAddCategory() throws Exception {
        Category category = new Category();
        category.setName("computer22");
        category.setDescription("ele");
        category.setParent(0);
        System.out.println(categoryService.addCategory(category));
        System.out.println(category);
    } 
    
    /** 
     * Method: updateCategory(Category category) 
     */ 
    @Test
    public void testUpdateCategory() throws Exception {
        Category category = categoryService.getById(1);
        category.setDescription("change des");
        categoryService.updateCategory(category);
    } 
    
    /** 
     * Method: deleteCategory(Category category) 
     */ 
    @Test
    public void testDeleteCategory() throws Exception {
        Category category = categoryService.getById(1);
        categoryService.deleteCategory(category.getId());
    }

    /**
     * Method: deleteCategory(int id) 
     */
    @Test
    public void testDeleteCategoryId() throws Exception {
        System.out.println(categoryService.deleteCategory(1));
    }
} 
