package com.yi.enhancement.controller.api;


import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.ICategoryService;
import com.yi.enhancement.service.ITagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final ITagService tagService;

    public TagController(ITagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/listTag")
    public JsonResult listTagDTO(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(tagService.listTagDTO());
        return jsonResult;
    }
}
