package com.yi.enhancement.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: lyric
 * @date: 2021/6/1 16:53
 * @description:
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model, HttpServletResponse response) {
        Long userId = 1L;
//        BlogWrapper blogWrapper = new BlogWrapper();
//        blogWrapper.setPage(1);
//        blogWrapper.setSize(8);
//        model.addAttribute("page", blogService.listBlog(blogWrapper));
//        model.addAttribute("types", typeService.listBlogType());
//        model.addAttribute("tags", tagService.listTag());
//        model.addAttribute("user", userService.updateViews(userId));
        return "index";
    }
}
