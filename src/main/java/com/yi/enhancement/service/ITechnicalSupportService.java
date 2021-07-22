package com.yi.enhancement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.TechnicalSupportDTO;
import com.yi.enhancement.model.entity.TechnicalSupport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 技术支持 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-07-15
 */
public interface ITechnicalSupportService extends IService<TechnicalSupport> {

    /**
     * 技术支持分页
     *
     * @param page     当前页
     * @param pageSize 每页数据量
     * @param realName 真实姓名
     * @return 技术支持列表
     */
    IPage<TechnicalSupportDTO> pageTechnicalSupport(Integer page, Integer pageSize, String realName);

    /**
     * 保存技术支持的相关信息
     *
     * @param technicalSupportDTO 文章DTO
     * @return 是否成功
     * @throws CustomException 异常
     */
    boolean saveTechnicalSupport(TechnicalSupportDTO technicalSupportDTO) throws CustomException;

    /**
     * 删除技术支持
     *
     * @param id 技术支持id
     * @return 是否成功
     */
    boolean deleteTechnicalSupport(Long id);

    /**
     * 根据技术支持id获得技术支持DTO
     *
     * @param id 技术支持id
     * @return 技术支持DTO
     */
    TechnicalSupportDTO getTechnicalSupport(Long id);
}
