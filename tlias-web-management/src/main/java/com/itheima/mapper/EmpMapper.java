package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 分页查询获取列表数据
     */
//    @Select("select * from emp limit #{start}, #{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize, String name, Short gender,
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
    void insertEmp(Emp emp);
}
