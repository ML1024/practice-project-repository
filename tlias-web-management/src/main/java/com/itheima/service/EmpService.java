package com.itheima.service;

import com.itheima.pojo.PageBean;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean getPage(Integer page, Integer pageSize);
}
