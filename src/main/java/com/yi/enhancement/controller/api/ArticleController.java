package com.yi.enhancement.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.model.vo.ArticleVo;
import com.yi.enhancement.model.vo.TagVo;
import com.yi.enhancement.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/articleList")
    public JsonResult articleList() throws CustomException {
        Map<String, List<ArticleVo>> stringListMap = articleService.listArticleVo(null, null, null);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(stringListMap);
        return jsonResult;
    }

    @GetMapping("/indexArticle")
    public JsonResult indexArticle() throws CustomException {
        IPage<ArticleDTO> articleDTOIPage = articleService.pageArticleWeb(null, null, null, 1, 16);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(articleDTOIPage);
        return jsonResult;
    }

    @GetMapping("/articleSearch")
    public JsonResult articleSearch(@RequestParam String queryCondition) throws CustomException {
        Map<String, List<ArticleVo>> stringListMap = articleService.listArticleVo(null, null, queryCondition);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(stringListMap);
        return jsonResult;
    }

    @GetMapping("/tag/{tagId}")
    public JsonResult tag(@PathVariable(required = false) Integer tagId) throws CustomException {
        Map<String, List<ArticleVo>> stringListMap = articleService.listArticleVo(null, tagId, null);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(stringListMap);
        return jsonResult;
    }

    @GetMapping("/category/{categoryId}")
    public JsonResult category(@PathVariable(required = false) Integer categoryId) throws CustomException {
        Map<String, List<ArticleVo>> stringListMap = articleService.listArticleVo(categoryId, null, null);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(stringListMap);
        return jsonResult;
    }

    @GetMapping("/pageArticle")
    public JsonResult pageArticle(String title, Integer status, Integer categoryId, Integer tagId, Integer page, Integer pageSize) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(articleService.pageArticle(title, status, categoryId, tagId, page, pageSize));
        return jsonResult;
    }

    @GetMapping("/getArticle")
    public JsonResult getArticle(Integer id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(articleService.getArticle(id));
        return jsonResult;
    }

    @GetMapping("/getArticleDetail")
    public JsonResult getArticleDetail(Integer id) {
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
    public JsonResult deleteArticle(Integer articleId) {
        articleService.deleteArticle(articleId);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }

}
