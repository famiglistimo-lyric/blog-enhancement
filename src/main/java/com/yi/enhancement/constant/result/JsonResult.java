package com.yi.enhancement.constant.result;

/**
 * @author: lyric
 * @date: 2021/6/25 18:58
 * @description: 封装Json返回信息
 */
public class JsonResult {

    private boolean success;
    private String status;
    private String msg;
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public JsonResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public JsonResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public JsonResult setObj(Object obj) {
        this.obj = obj;
        return this;
    }

}