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
 * 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class ArticleTagRelationServiceImpl extends ServiceImpl<ArticleTagRelationMapper, ArticleTagRelation> implements IArticleTagRelationService {

    @Override
    public List<Integer> listArticleId(Integer tagId) {
        return this.baseMapper.listArticleId(tagId);
    }

    @Override
    public List<ArticleTagRelationDTO> listArticleTagRelation(List<Integer> articleIds) {
        return this.baseMapper.listArticleTagRelation(articleIds);
    }

    @Override
    public List<ArticleTagRelation> listArticleTagRelationByArticleId(Integer articleId, Integer deleted) {
        return this.baseMapper.listArticleTagRelationByArticleId(articleId, deleted);
    }

    @Override
    public void deleteReally(Integer articleId) {
        this.baseMapper.deleteReally(articleId);
    }
}
