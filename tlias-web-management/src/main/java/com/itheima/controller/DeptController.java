package com.itheima.controller;


import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController = @ResponseBody + @Controller

@Slf4j
@RestController
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @RequestMapping("/depts")
    public Result getList(){

        log.info("查询全部的部门数据");
        return Result.success();
    }

}
