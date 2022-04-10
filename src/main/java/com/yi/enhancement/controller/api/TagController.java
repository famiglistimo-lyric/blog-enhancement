package com.yi.enhancement.controller.api;


import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.CategoryDTO;
import com.yi.enhancement.model.dto.TagDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.ICategoryService;
import com.yi.enhancement.service.ITagService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pageTag")
    public JsonResult pageTag(Integer page, Integer pageSize){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(tagService.pageTag(page, pageSize));
        return jsonResult;
    }

    @PostMapping("/saveTag")
    public JsonResult saveTag(@RequestBody TagDTO tagDTO) throws CustomException {
        tagService.saveTag(tagDTO);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }

    @GetMapping("/deleteTag")
    public JsonResult deleteTag(Integer id){
        tagService.deleteTag(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }
}
