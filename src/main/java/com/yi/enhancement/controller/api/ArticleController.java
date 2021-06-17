package com.yi.enhancement.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lyric
 * @date: 2021/5/28 19:47
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final IArticleService articleService;

    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/pageArticle")
    public IPage<ArticleDTO> pageArticle(String title, Integer page, Integer pageSize) {
        return articleService.pageArticle(title, page, pageSize);
    }
}
