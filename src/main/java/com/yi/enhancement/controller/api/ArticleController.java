package com.yi.enhancement.controller.api;

import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public JsonResult pageArticle(String title, Integer status, Long categoryId, Long tagId, Integer page, Integer pageSize) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(articleService.pageArticle(title, status, categoryId, tagId, page, pageSize));
        return jsonResult;
    }

    @GetMapping("/getArticle")
    public JsonResult getArticle(Long id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(articleService.getArticle(id));
        return jsonResult;
    }

    @GetMapping("/getArticleDetail")
    public JsonResult getArticleDetail(Long id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(articleService.getArticleDetail(id));
        return jsonResult;
    }

    @PostMapping("/saveArticle")
    public JsonResult saveArticle(@RequestBody ArticleDTO articleDTO) throws CustomException {
        articleService.saveArticle(articleDTO);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }

    @GetMapping("/deleteArticle")
    public JsonResult deleteArticle(Long articleId) {
        articleService.deleteArticle(articleId);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }

}
