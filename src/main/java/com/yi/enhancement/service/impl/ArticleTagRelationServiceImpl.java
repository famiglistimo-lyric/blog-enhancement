package com.yi.enhancement.service.impl;

import com.yi.enhancement.model.dto.ArticleTagRelationDTO;
import com.yi.enhancement.model.entity.ArticleTagRelation;
import com.yi.enhancement.mapper.ArticleTagRelationMapper;
import com.yi.enhancement.service.IArticleTagRelationService;
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
public class ArticleTagRelationServiceImpl extends ServiceImpl<ArticleTagRelationMapper, ArticleTagRelation> implements IArticleTagRelationService {

    @Override
    public List<Long> listArticleId(Long tagId) {
        return this.baseMapper.listArticleId(tagId);
    }

    @Override
    public List<ArticleTagRelationDTO> listArticleTagRelation(List<Long> articleIds) {
        return this.baseMapper.listArticleTagRelation(articleIds);
    }

    @Override
    public List<ArticleTagRelation> listArticleTagRelationByArticleId(Long articleId) {
        return this.baseMapper.listArticleTagRelationByArticleId(articleId);
    }
}
