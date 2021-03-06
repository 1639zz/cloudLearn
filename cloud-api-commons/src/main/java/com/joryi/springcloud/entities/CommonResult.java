package com.joryi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: com.joryi.spingcloud
 * @description: Json封装体CommentResult, 传给前端，判断编码是否成功，成功才显示
 * @author: joryizhang
 * @create: 2021-10-15 17:06
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}