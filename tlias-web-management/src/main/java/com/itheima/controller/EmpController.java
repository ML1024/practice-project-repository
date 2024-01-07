package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping
    public Result getPage(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10")Integer pageSize){
        log.info("分页查询，参数：{},{}", page, pageSize);
        //调用service分页查询
        PageBean pageBean = empService.getPage(page, pageSize);
        return Result.success(pageBean);
    }

}
