package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@RestController = @ResponseBody + @Controller


@Slf4j
@RestController
public class DeptController {
    //固定代码引入日志（可以用注解 @Slf4j 代替）
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result getDeptList(){

        log.info("查询全部的部门数据");

        //调用service查询部门数据
        List<Dept> deptList = deptService.getDeptList();

        return Result.success();
    }

}
