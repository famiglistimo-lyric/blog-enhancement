package com.yi.enhancement.controller.content;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.UserDTO;
import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.model.entity.User;
import com.yi.enhancement.model.vo.CategoryVo;
import com.yi.enhancement.model.vo.TagVo;
import com.yi.enhancement.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: lyric
 * @date: 2021/6/1 16:53
 * @description:
 */
@Slf4j
@Controller
public class MainController {

    private final IArticleService articleService;

    private final ICategoryService categoryService;

    private final ITagService tagService;

    private final IUserService userService;

    private final ITechnicalSupportService technicalSupportService;

    public MainController(IArticleService articleService,
                          ICategoryService categoryService,
                          ITagService tagService,
                          IUserService userService,
                          ITechnicalSupportService technicalSupportService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.tagService = tagService;
        this.userService = userService;
        this.technicalSupportService = technicalSupportService;
    }

    @GetMapping("/")
    public String index(Model model, HttpServletResponse response) {
        Long userId = 1L;
        int currentPage = 1;
        int pageSize = 8;
        model.addAttribute("articlePage", articleService.pageArticleWeb(null,null,null,currentPage, pageSize));
        model.addAttribute("tagList", tagService.listTagVo());
        model.addAttribute("categoryList", categoryService.listCategoryVo());
        model.addAttribute("user", userService.updateViews(userId));
        model.addAttribute("technicalSupportList", technicalSupportService.listTechnicalSupportVo());
        return "index";
    }

    @GetMapping("/article/{id}")
    public String blog(@PathVariable Long id, Model model) throws CustomException {
        UserDTO user = userService.getUser(1L);
        model.addAttribute("user", user);
        Article article = articleService.getAndConvert(id);
        model.addAttribute("article", article);
        Long articleId = article.getId();
        model.addAttribute("categoryList", categoryService.listCategoryVoHit(articleId));
        model.addAttribute("tagList", tagService.listTagVoHit(articleId));
        return "article";
    }

    @GetMapping("/main/articleList/category/{categoryId}")
    public String category(@PathVariable(required = false) Long categoryId,
                           Model model) throws CustomException {
        model.addAttribute("articlePage", articleService.pageArticleWeb(null,null,null,null, null));
        model.addAttribute("archiveMap", articleService.listArticleVo(categoryId, null, null));
        model.addAttribute("tagList", tagService.listTagVo());
        List<CategoryVo> categoryVos = categoryService.listCategoryVo();
        for (CategoryVo categoryVo : categoryVos) {
            Long id = categoryVo.getId();
            if(categoryId.equals(id)){
                categoryVo.setHit(true);
                break;
            }
        }
        model.addAttribute("categoryList", categoryVos);
        Long userId = 1L;
        model.addAttribute("user", userService.updateViews(userId));
        model.addAttribute("technicalSupportList", technicalSupportService.listTechnicalSupportVo());
        return "articleList";
    }

    @GetMapping("/main/articleList/tag/{tagId}")
    public String tag(@PathVariable(required = false) Long tagId,
                           Model model) throws CustomException {
        model.addAttribute("articlePage", articleService.pageArticleWeb(null,null,null,null, null));
        model.addAttribute("archiveMap", articleService.listArticleVo(null, tagId, null));
        List<TagVo> tagVos = tagService.listTagVo();
        for (TagVo tagVo : tagVos) {
            Long id = tagVo.getId();
            if(tagId.equals(id)){
                tagVo.setHit(true);
                break;
            }
        }
        model.addAttribute("tagList", tagVos);
        model.addAttribute("categoryList", categoryService.listCategoryVo());
        Long userId = 1L;
        model.addAttribute("user", userService.updateViews(userId));
        model.addAttribute("technicalSupportList", technicalSupportService.listTechnicalSupportVo());
        return "articleList";
    }

    @GetMapping("/main/articleList")
    public String articleList(Model model) throws CustomException {
        model.addAttribute("articlePage", articleService.pageArticleWeb(null,null,null,null, null));
        model.addAttribute("archiveMap", articleService.listArticleVo(null, null, null));
        model.addAttribute("tagList", tagService.listTagVo());
        model.addAttribute("categoryList", categoryService.listCategoryVo());
        Long userId = 1L;
        model.addAttribute("user", userService.updateViews(userId));
        model.addAttribute("technicalSupportList", technicalSupportService.listTechnicalSupportVo());
        return "articleList";
    }
}
