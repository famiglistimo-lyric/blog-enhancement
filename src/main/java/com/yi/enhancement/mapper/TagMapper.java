package com.yi.enhancement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.enhancement.model.vo.TagVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  文章标签表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 查询全部的文章标签
     * @return 文章标签List
     */
    List<TagDTO> listTagDTO();

    /**
     * 查询全部的文章标签
     * @return 文章标签List
     */
    List<TagVo> listTagVo();

    /**
     * 标签分页
     * @param pageCondition 分页条件
     * @return 标签列表
     */
    IPage<TagDTO> pageTag(Page<TagDTO> pageCondition);
}
