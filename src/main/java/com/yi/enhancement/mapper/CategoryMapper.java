package com.yi.enhancement.mapper;

import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 文章分类 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询全部的文章分类
     * @return 文章分类List
     */
    List<CategoryDTO> listCategoryDTO();
}