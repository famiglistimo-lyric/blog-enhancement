package com.yi.enhancement.mapper;

import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  文章标签表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 查询全部的文章标签
     * @return 文章标签List
     */
    List<TagDTO> listCategoryDTO();
}
