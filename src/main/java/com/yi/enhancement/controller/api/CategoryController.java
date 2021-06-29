package com.yi.enhancement.controller.api;


import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.IArticleService;
import com.yi.enhancement.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pageCategory")
    public JsonResult pageCategory(Integer page, Integer pageSize){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(categoryService.pageCategory(page, pageSize));
        return jsonResult;
    }

    @PostMapping("/saveCategory")
    public JsonResult saveCategory(@RequestBody CategoryDTO categoryDTO) throws CustomException {
        categoryService.saveCategory(categoryDTO);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }
}
