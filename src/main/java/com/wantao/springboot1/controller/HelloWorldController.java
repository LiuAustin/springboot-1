package com.wantao.springboot1.controller;

import com.wantao.springboot1.Service.UserService;
import com.wantao.springboot1.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloWorldController {
    @Autowired
    User user;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello Springboot";
    }

    //返回freemarker
    @RequestMapping("/freemarker")
    public String freemarkerTest(Map<String, Object> map) {
        map.put("name", "万涛");
        map.put("age", "20");
        map.put("sex", "男");
        return "freemarker";
    }

    //简单的异常捕获
    /*
    @RequestMapping("/getError")
    @ResponseBody
    public String getError(int i) {
        int j = 0;
        try {
            j = j / i;

        } catch (Exception e) {
            return "发生异常";
        }
        return "Success";
    }
    */
    @RequestMapping("/getError")
    @ResponseBody
    public String getError(int i) {
        int j = 0;
        j = j / i;
        return "Success";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/findUserByName")
    @ResponseBody
    public String findUserByName(@Param("name") String name) {
        return userService.findUserByName(name).toString();

    }

    @RequestMapping("/insertUser")
    @ResponseBody
    @Transactional
    /*
     * 这个例子说明了@Transactional的作用
     * 当没有加这个注解时，执行到userService.insertUser(user);时,就已经插入了,后面ｊ/0报错，但数据还是插入了，不符合一致性
     * 当有这个注解后,执行到userService.insertUser(user);时，并没有插入,之后报错,也不再插入
     * */
    public String insertUser(int i) {
        int j = 0;
        User user = new User();
        user.setName("万晓菲");
        user.setAge(24);
        userService.insertUser(user);
        j = j / i;
        return "Success";
    }

    //测试自定义参数
    @RequestMapping(value = "/showUser")
    @ResponseBody
    public String showUser() {
        return user.toString();
    }


}
