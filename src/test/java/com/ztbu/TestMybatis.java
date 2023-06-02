package com.ztbu;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;
import com.ztbu.mapper.brandMapper;
import com.ztbu.pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    @Test
    public void testSelectAll() throws IOException {
        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(com.ztbu.mapper.brandMapper.class);
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //4.释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectByTj() throws IOException {
        // 接受参数
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";
        //处理参数
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";
        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(com.ztbu.mapper.brandMapper.class);
/*        List<Brand> brands = brandMapper.selectByTj(status,brand_name,company_name);
        System.out.println(brands);*/

/*        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        List<Brand> brands = brandMapper.selectByTj(brand);
        System.out.println(brands);*/

        Map map = new HashMap();
        map.put("status",status);
        map.put("brandName",brandName);
        map.put("companyName",companyName);
        List<Brand> brands = brandMapper.selectByTj(map);
        System.out.println(brands);
        //4.释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectByTjSingle() throws IOException {
        // 接受参数
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";
        //处理参数
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";
        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(com.ztbu.mapper.brandMapper.class);

/**
 * 单个条件查询  只需要一个属性值
 */
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        List<Brand> brands = brandMapper.selectByTjSingle(brand);
        System.out.println(brands);


        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testadd() throws IOException {
        // 接受参数
        int status = 1;
        String brandName = "小米";
        String companyName = "小米";
        String description = "Xiaomi";
        int ordered = 100;

        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession(true);// true :自动提交事务
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(com.ztbu.mapper.brandMapper.class);


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brandMapper.add(brand);
        System.out.println(brand.getId());// 返回主键 打印id

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testupdate() throws IOException {
        // 接受参数
        int status = 1;
        String brandName = "小米";
        String companyName = "小米";
        String description = "Xiaomi";
        int ordered = 200;
        int id = 5;

        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession(true);// true :自动提交事务
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(com.ztbu.mapper.brandMapper.class);


        Brand brand = new Brand();
 /*       brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);*/
        brand.setOrdered(ordered); //只修改数量 只需要ordered参数
        brand.setId(id);
        brandMapper.update(brand);


        //4.释放资源
        sqlSession.close();
    }
    @Test
    public void testdeletes() throws IOException {
        // 接受参数
        int [] ids = {6,7};

        //1.加载mybatis核心配置文件 获取sqlsessionFactory
        String resoure = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resoure);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象 用来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();// true :自动提交事务
        //3.获取Mapper接口的代理对象
        brandMapper brandMapper = sqlSession.getMapper(com.ztbu.mapper.brandMapper.class);



        brandMapper.deletes(ids);
        sqlSession.commit();//增删改要提交事务

        //4.释放资源
        sqlSession.close();
    }
}
