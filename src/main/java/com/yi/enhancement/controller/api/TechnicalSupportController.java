package com.yi.enhancement.controller.api;


import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.TechnicalSupportDTO;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.ITechnicalSupportService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 技术支持 前端控制器
 * </p>
 *
 * @author lwj
 * @since 2021-07-15
 */
@RestController
@RequestMapping("/api/technical-support")
public class TechnicalSupportController {

    private final ITechnicalSupportService technicalSupportService;

    public TechnicalSupportController(ITechnicalSupportService technicalSupportService) {
        this.technicalSupportService = technicalSupportService;
    }

    @GetMapping("/pageTechnicalSupport")
    public JsonResult pageTechnicalSupport(Integer page, Integer pageSize, String realName) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setObj(technicalSupportService.pageTechnicalSupport(page, pageSize, realName));
        return jsonResult;
    }

    @PostMapping("/saveTechnicalSupport")
    public JsonResult saveTechnicalSupport(@RequestBody TechnicalSupportDTO technicalSupportDTO) throws CustomException {
        technicalSupportService.saveTechnicalSupport(technicalSupportDTO);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }

    @GetMapping("/deleteTechnicalSupport")
    public JsonResult deleteTechnicalSupport(Long id) {
        technicalSupportService.deleteTechnicalSupport(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }
}
