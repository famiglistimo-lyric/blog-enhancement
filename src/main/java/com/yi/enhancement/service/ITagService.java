package com.yi.enhancement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException.CustomException;
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

    /**
     * 标签分页
     * @param page 当前页
     * @param pageSize 每页数据量
     * @return 标签列表
     */
    IPage<TagDTO> pageTag(Integer page, Integer pageSize);

    /**
     * 保存文章标签
     * @param tagDTO 文章标签DTO
     * @return 是否成功
     * @throws CustomException 自定义异常
     */
    boolean saveTag(TagDTO tagDTO) throws CustomException;

    /**
     * 删除标签
     * @param id 文章标签id
     * @return 是否成功
     */
    boolean deleteTag(Long id);
}
