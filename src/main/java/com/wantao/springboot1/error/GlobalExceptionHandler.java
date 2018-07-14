package com.wantao.springboot1.error;/*
 *author:wantao
 *createTime:18-6-26 23:34
 *description:全局捕获异常
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.wantao.springboot1.controller")
public class GlobalExceptionHandler {
    /*
     * @ResponseBody返回json
     * @ModelAndView返回视图
     * */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> errorResult() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("statusCode", "500");
        hashMap.put("errorMsg", "全局异常捕获:系统内部异常");
        return hashMap;
    }
}
