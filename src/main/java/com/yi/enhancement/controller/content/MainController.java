package com.yi.enhancement.controller.content;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.UserDTO;
import com.yi.enhancement.model.entity.User;
import com.yi.enhancement.service.IArticleService;
import com.yi.enhancement.service.ICategoryService;
import com.yi.enhancement.service.ITagService;
import com.yi.enhancement.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

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

    public MainController(IArticleService articleService,
                          ICategoryService categoryService,
                          ITagService tagService,
                          IUserService userService){
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.tagService = tagService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, HttpServletResponse response) {
        Long userId = 1L;
        int currentPage = 1;
        int pageSize = 8;
        model.addAttribute("articlePage",articleService.pageArticleWeb(currentPage,pageSize));
        model.addAttribute("categoryList", categoryService.listCategoryDTO());
        model.addAttribute("tagList", tagService.listTagDTO());
        model.addAttribute("user", userService.updateViews(userId));
        return "index";
    }

    @GetMapping("/article/{id}")
    public String blog(@PathVariable Long id, Model model) throws CustomException {
        UserDTO user = userService.getUser(1L);
        model.addAttribute("user", user);
        model.addAttribute("article", articleService.getAndConvert(id));
        return "article";
    }
}
