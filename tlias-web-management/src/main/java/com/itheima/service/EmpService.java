package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean getPage(Integer page, Integer pageSize, String name, Short gender,
                     LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void addEmp(Emp emp);
}
