package com.yi.enhancement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.enhancement.model.vo.CategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 文章分类 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询全部的文章分类
     * @return 文章分类List
     */
    List<CategoryDTO> listCategoryDTO();

    /**
     * 查询全部的文章分类
     * @return 文章分类List
     */
    List<CategoryVo> listCategoryVo();

    /**
     * 分类分页
     * @param pageCondition 分页条件
     * @return 分类列表
     */
    IPage<CategoryDTO> pageCategory(Page<CategoryDTO> pageCondition);



}
