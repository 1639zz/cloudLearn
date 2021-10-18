package com.joryi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: com.joryi.spingcloud
 * @description: 实体类
 * @author: joryizhang
 * @create: 2021-10-15 17:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;

}
