package com.yi.enhancement.controller.api;

import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/getSomething")
    public boolean listAll() {
        System.out.println("你好,wolaile1");
        return true;
    }
}
