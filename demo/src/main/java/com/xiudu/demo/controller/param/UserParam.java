package com.xiudu.demo.controller.param;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @author: 锈渎
 * @date: 2023/12/11 15:02
 * @code: 面向对象面向君， 不负代码不负卿。
 * @description: 对User的数据进行参数校验
 */

@Getter
@Setter
public class UserParam {

    // 定义分组接口
    public interface FirstGroup{}
    public interface SecondGroup{}

    @GroupSequence({FirstGroup.class, SecondGroup.class})
    public interface AllGroup{}


    @NotNull(message = "User ID cannot be null", groups = FirstGroup.class) // 对于第一个接口的校验规则
    @Max(value = 10, message = "User ID Length should be 1-10", groups = SecondGroup.class) // 对于第二个接口的校验规则
    private Long userId;

    @NotEmpty(message = "cardNo cannot be null", groups = AllGroup.class) // 对于所有接口的校验规则
    private String cardNo;
}
