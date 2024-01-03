package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*
    * 查询全部部门
    * @return
    * */
    @Select("select * from dept")
    List<Dept> getDeptList();


    /*
    * 根据id删除部门
    * @param id
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
