package com.ztbu.mapper;
import com.ztbu.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface brandMapper {
    List<Brand> selectAll(); //查询所有

    Brand selectById(int id);    //通过id查询
    //条件查询 ： 动态sql

    /**
     * Mybatis需要传递多个参数时有三种方法
     * 1.使用 `@Param("参数名称")` 标记每一个参数
     * 2.将多个参数封装成一个 实体对象 ，将该实体对象作为接口的方法参数。该方式要求在映射配置文件的SQL中使用 `#{内容}` 时，里面的内容必须和实体类属性名保持一致。
     * 3.将多个参数封装到map集合中，将map集合作为接口的方法参数。该方式要求在映射配置文件的SQL中使用 `#{内容}` 时，里面的内容必须和map集合中键的名称一致。
     */
   /* List<Brand> selectByTj(@Param("status")int status,@Param("brand_name")String brand_name,@Param("company_name")String company_name);*/
 /*   List<Brand> selectByTj(Brand brand);*/
    List<Brand> selectByTj(Map map); //多条件查询
    List<Brand> selectByTjSingle(Brand brand); // 单条件查询  （下拉选择框）

    void add(Brand brand); //添加数据
    void update(Brand brand);//修改数据

    void delete(Brand brand);//删除单个

    void deletes(int [] ids); //删除多条数据
}
