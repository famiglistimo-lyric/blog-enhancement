package com.yi.enhancement.controller.api;


import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.IArticleService;
import com.yi.enhancement.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 文章分类 前端控制器
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/listCategory")
    public JsonResult listCategoryDTO(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(categoryService.listCategoryDTO());
        return jsonResult;
    }
}
