package com.yi.enhancement.service;

import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface ITagService extends IService<Tag> {

    /**
     * 查询全部的文章标签
     * @return 文章标签List
     */
    List<TagDTO> listTagDTO();
}
