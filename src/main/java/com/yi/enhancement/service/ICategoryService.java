package com.yi.enhancement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.enhancement.model.vo.CategoryVo;

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

    /**
     * 查询全部的文章分类
     * @return 文章分类List
     */
    List<CategoryVo> listCategoryVo();

    /**
     * 查询全部的文章分类并且标识该文章所属的分类
     * @param articleId 文章id
     * @return 文章分类List
     */
    List<CategoryVo> listCategoryVoHit(Integer articleId);

    /**
     * 分类分页
     * @param page 当前页
     * @param pageSize 每页数据量
     * @return 分类列表
     */
    IPage<CategoryDTO> pageCategory(Integer page, Integer pageSize);

    /**
     * 保存文章分类
     * @param categoryDTO 文章分类DTO
     * @return 是否成功
     * @throws CustomException 自定义异常
     */
    boolean saveCategory(CategoryDTO categoryDTO) throws CustomException;

    /**
     * 删除分类
     * @param id 文章分类id
     * @return 是否成功
     */
    boolean deleteCategory(Integer id);
}
