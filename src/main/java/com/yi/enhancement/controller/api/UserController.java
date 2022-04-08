package com.yi.enhancement.controller.api;


import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.model.dto.UserDTO;
import com.yi.enhancement.model.entity.User;
import com.yi.enhancement.model.result.JsonResult;
import com.yi.enhancement.service.ITagService;
import com.yi.enhancement.service.IUserService;
import org.springframework.web.bind.annotation.*;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 * <p>
 * 用户表	 前端控制器
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getViews")
    public JsonResult getViews(Long id) {
        User user = userService.updateViews(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        jsonResult.setObj(user.getViews());
        return jsonResult;
    }

    @GetMapping("/getUser")
    public JsonResult getUser(Long id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        jsonResult.setObj(userService.getUser(id));
        return jsonResult;
    }

    @PostMapping("/saveUser")
    public JsonResult saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setMsg(Constant.HANDLE_SUCCESS);
        return jsonResult;
    }
}
