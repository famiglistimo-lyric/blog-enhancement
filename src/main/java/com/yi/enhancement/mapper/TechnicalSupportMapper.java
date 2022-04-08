package com.yi.enhancement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.TechnicalSupportDTO;
import com.yi.enhancement.model.entity.TechnicalSupport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.enhancement.model.vo.TechnicalSupportVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 技术支持 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-07-15
 */
public interface TechnicalSupportMapper extends BaseMapper<TechnicalSupport> {

    /**
     * 技术支持分页
     *
     * @param pageCondition 查询条件
     * @param realName 真实姓名
     * @return 技术支持列表
     */
    IPage<TechnicalSupportDTO> pageTechnicalSupportDTO(Page<TechnicalSupportDTO> pageCondition, String realName);

    /**
     * 根据技术支持id获得技术支持DTO
     * @param id 技术支持id
     * @return 技术支持DTO
     */
    TechnicalSupportDTO getTechnicalSupport(Long id);

    /**
     * 获得技术支持Vo的list
     *
     * @return 技术支持Vo的list
     */
    List<TechnicalSupportVo> listTechnicalSupportVo();
}
