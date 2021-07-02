package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.exception.ExceptionCodeEnum;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.entity.Category;
import com.yi.enhancement.model.entity.Tag;
import com.yi.enhancement.mapper.TagMapper;
import com.yi.enhancement.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Override
    public List<TagDTO> listTagDTO() {
        List<TagDTO> tagDTOS = this.baseMapper.listCategoryDTO();
        return tagDTOS;
    }

    @Override
    public IPage<TagDTO> pageTag(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<TagDTO> pageCondition = new Page<>(page, pageSize);
        return this.baseMapper.pageTag(pageCondition);
    }

    @Override
    public boolean saveTag(TagDTO tagDTO) throws CustomException {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagDTO,tag);
        try {
            this.saveOrUpdate(tag);
        } catch (DuplicateKeyException e) {
            throw new CustomException(ExceptionCodeEnum.TAG_EXISTED_EXCEPTION.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteTag(Long id) {
        this.removeById(id);
        return true;
    }
}
