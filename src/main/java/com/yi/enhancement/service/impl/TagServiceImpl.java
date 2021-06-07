package com.yi.enhancement.service.impl;

import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.entity.Tag;
import com.yi.enhancement.mapper.TagMapper;
import com.yi.enhancement.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        return this.baseMapper.listCategoryDTO();
    }
}
