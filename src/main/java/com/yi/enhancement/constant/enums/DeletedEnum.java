package com.yi.enhancement.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeletedEnum {

    DELETED(1, "已删除"),
    UNDELETED(0, "未删除");

    public Integer code;
    public String description;
}
