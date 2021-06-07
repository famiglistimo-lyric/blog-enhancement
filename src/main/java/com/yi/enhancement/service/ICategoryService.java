package com.yi.enhancement.service;

import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface ICategoryService extends IService<Category> {

    /**
     * 查询全部的文章分类
     * @return 文章分类List
     */
    List<CategoryDTO> listCategoryDTO();
}
