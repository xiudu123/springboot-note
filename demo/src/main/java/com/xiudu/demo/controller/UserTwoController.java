package com.xiudu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xiudu.demo.config.api.Result;
import com.xiudu.demo.config.handler.CustomException;
import com.xiudu.demo.controller.param.UserParam;
import com.xiudu.demo.pojo.User;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: 锈渎
 * @date: 2023/12/9 19:15
 * @code: 面向对象面向君， 不负代码不负卿。
 * @description:
 */



@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
@Validated
public class UserTwoController {


    @Operation(summary = "测试", description = "测试接口")
    @PostMapping("/add/success")
    public Result<?> userAddSuccess(@RequestBody @Validated(UserParam.FirstGroup.class) UserParam jsonParam) {
        System.out.println(jsonParam);
        // 处理 jsonParam

        return Result.success(jsonParam);
    }

    @Operation(summary = "测试2", description = "测试接口2")
    @PostMapping("/add/success/2")
    public Result<?> userAddSuccess2(@RequestBody @Validated(UserParam.SecondGroup.class) UserParam jsonParam) {
        System.out.println(jsonParam);
        // 处理 jsonParam

        return Result.success(jsonParam);
    }


    @PostMapping("/add/fail")
    public Result<?> userAddFail() {
        throw new CustomException("自定义错误");
//        throw new RuntimeException();
//        return Result.error("fail");
    }
}
