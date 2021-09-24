package com.yi.enhancement.controller.api;

import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.IDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lyric
 * @date: 2021/9/18 11:42
 * @description: 分析台 前端控制器
 */
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final IDashboardService dashboardService;

    public DashboardController(IDashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/analysis")
    public JsonResult analysis() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(dashboardService.analysis());
        return jsonResult;
    }
}
