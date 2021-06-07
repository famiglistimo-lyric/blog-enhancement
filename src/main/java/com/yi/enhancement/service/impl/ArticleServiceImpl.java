package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.mapper.ArticleMapper;
import com.yi.enhancement.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Override
    public IPage<ArticleDTO> pageArticleDTO(int currentPage, int size) {
        Page<ArticleDTO> pageCondition = new Page<>(currentPage, size);
        return this.baseMapper.pageArticleDTO(pageCondition);
    }
}
