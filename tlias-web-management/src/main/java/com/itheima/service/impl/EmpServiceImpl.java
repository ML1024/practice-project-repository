package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    private Emp emp;

    @Override
    public PageBean getPage(Integer page, Integer pageSize, String name, Short gender,
                            LocalDate begin, LocalDate end) {
        //1.获取总记录数
        Long count = empMapper.count();
        //2.获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize, name, gender, begin, end);
        //3.封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);

        return pageBean;
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insertEmp(emp);
    }

    @Override
    public Emp login(Emp emp) {
        this.emp = emp;
        //login是业务方法，不建议使用这个名字
        //操作数据库的方法可以叫 getByUsernameAndPassword
        return empMapper.getByUsernameAndPassword(emp);
    }
}