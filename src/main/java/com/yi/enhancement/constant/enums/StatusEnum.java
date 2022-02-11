package com.yi.enhancement.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    PUBLIC(1, "发布"),
    DRAFT(0, "草稿");

    public Integer code;
    public String description;
}
