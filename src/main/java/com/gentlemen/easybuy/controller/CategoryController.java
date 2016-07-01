package com.gentlemen.easybuy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.entity.Category;
import com.gentlemen.easybuy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 6/30/16
 */
@Controller
@RequestMapping("/api/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取所有商品分类信息
     * @return JSON 数组
     * @throws Exception
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseBody
    public String getAllCategories() throws Exception{
        List<Category> list = categoryService.getAllCategories();
        return new ObjectMapper().writeValueAsString(list);
    }

    /**
     * 添加商品类别,如果添加不成功返回状态码400
     *
     * @param category 商品类别
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(path = "", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String addCategory(@RequestBody Category category, HttpServletResponse response) throws Exception {
        try {
            categoryService.addCategory(category);
            return new ObjectMapper().writeValueAsString(category);
        } catch (Exception e) {
            response.sendError(400);
        }
        return "";
    }

    /**
     * 更新某个分类
     * @param category 商品分类
     * @param response HttpServletResponse
     * @return 更新成功返回 Category 对象 JSON,失败状态码为400
     * @throws Exception
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public String updateCategory(@RequestBody Category category, HttpServletResponse response) throws Exception {
        if(categoryService.updateCategory(category)) {
            return new ObjectMapper().writeValueAsString(category);
        } else {
            response.sendError(400);
            return "";
        }
    }

    /**
     * 根据分类 ID 删除分类
     *
     * @param id 分类 ID
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable int id, HttpServletResponse response) throws IOException {
        if(!categoryService.deleteCategory(id))
            response.sendError(400);
    }

}
