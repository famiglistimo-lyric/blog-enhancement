package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.entity.Category;
import com.yi.enhancement.mapper.CategoryMapper;
import com.yi.enhancement.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public List<CategoryDTO> listCategoryDTO() {
        return this.baseMapper.listCategoryDTO();
    }
}
