package com.xiudu.demo.config.handler;

import com.xiudu.demo.config.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 锈渎
 * @date: 2023/6/24 0:46
 * @code: 面向对象面向君， 不负代码不负卿。
 * @description: 自定义错误拦截器, 同一处理页面错误判断
 */

@ControllerAdvice // 拦截所有标注有Controller注解的错误
@Slf4j
public class ControllerExceptionHandler {

    //定义这是一个异常处理类方法Exception异常都会经过该方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> exceptionHandel(Exception e) throws Exception {
        //错误信息打印成日志
        log.error("Exception : ",e);
        if(e instanceof CustomException exception) { // 返回自定义错误;
            return Result.error(exception.getCode(), exception.getMessage());
        }else if(e instanceof RuntimeException){ // 返回 400;
            return Result.error("Runtime Error");
        }else  return Result.error("系统错误"); // 返回其他系统错误
    }

}