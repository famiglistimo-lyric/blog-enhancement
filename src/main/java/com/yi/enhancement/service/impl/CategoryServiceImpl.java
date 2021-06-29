package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.exception.ExceptionCodeEnum;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.entity.Category;
import com.yi.enhancement.mapper.CategoryMapper;
import com.yi.enhancement.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
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

    @Override
    public IPage<CategoryDTO> pageCategory(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<CategoryDTO> pageCondition = new Page<>(page, pageSize);
        return this.baseMapper.pageCategory(pageCondition);
    }

    @Override
    public boolean saveCategory(CategoryDTO categoryDTO) throws CustomException {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        try {
            this.saveOrUpdate(category);
        } catch (DuplicateKeyException e) {
            throw new CustomException(ExceptionCodeEnum.CATEGORY_EXISTED_EXCEPTION.getMessage());
        }
        return true;
    }
}
