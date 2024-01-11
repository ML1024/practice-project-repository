package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}", emp);
        Emp e = empService.login(emp);//返回员工对象
        //如果有这个员工，返回success，登录成功
        //如果没有这个员工，登录失败，提示用户名或密码错误
        return e != null ? Result.success(): Result.error("用户名或密码错误") ;
    }
}
