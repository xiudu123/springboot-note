package com.xiudu.demo.controller;

import com.xiudu.demo.config.api.Result;
import com.xiudu.demo.config.handler.CustomException;
import com.xiudu.demo.pojo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


/**
 * @author: 锈渎
 * @date: 2023/12/9 19:15
 * @code: 面向对象面向君， 不负代码不负卿。
 * @description:
 */



@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
public class UserTwoController {


    @Operation(summary = "测试", description = "测试接口")
    @PostMapping("/add/success")
    public Result<?> userAddSuccess(User user1) {
        User user = new User(1L, 20, "111", "123", "12345", 2);
        return Result.success(user);

    }


    @PostMapping("/add/fail")
    public Result<?> userAddFail() {
        throw new CustomException("自定义错误");
//        throw new RuntimeException();
//        return Result.error("fail");
    }
}
