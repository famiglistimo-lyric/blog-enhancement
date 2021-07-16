package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.exception.ExceptionCodeEnum;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.TechnicalSupportDTO;
import com.yi.enhancement.model.entity.TechnicalSupport;
import com.yi.enhancement.mapper.TechnicalSupportMapper;
import com.yi.enhancement.service.ITechnicalSupportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 技术支持 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-07-15
 */
@Service
public class TechnicalSupportServiceImpl extends ServiceImpl<TechnicalSupportMapper, TechnicalSupport> implements ITechnicalSupportService {

    @Override
    public IPage<TechnicalSupportDTO> pageTechnicalSupport(Integer page, Integer pageSize, String realName) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        Page<TechnicalSupportDTO> pageCondition = new Page<>(page,pageSize);
        return this.baseMapper.pageTechnicalSupportDTO(pageCondition,realName);
    }

    @Override
    public boolean saveTechnicalSupport(TechnicalSupportDTO technicalSupportDTO) throws CustomException {
        TechnicalSupport technicalSupport = new TechnicalSupport();
        BeanUtils.copyProperties(technicalSupportDTO,technicalSupport);
        try {
            this.saveOrUpdate(technicalSupport);
        } catch (DuplicateKeyException e) {
            throw new CustomException(ExceptionCodeEnum.EXISTED_EXCEPTION.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteTechnicalSupport(Long id) {
        this.removeById(id);
        return true;
    }
}
