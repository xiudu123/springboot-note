package com.xiudu.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 锈渎
 * @date: 2023/12/9 15:47
 * @code: 面向对象面向君， 不负代码不负卿。
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private Integer age;
    private String nickName;
    private String email;
    private String cardNo;
    private Integer sex;
}
