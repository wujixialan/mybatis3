package com.zxg.test;

import com.zxg.dao.EmployeeMapperDynamicSql;
import com.zxg.mybatis.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by zxg on 2017/6/5.
 */
public class EmployeeMapperDynamicSqlTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @BeforeEach
    public void init() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetEmpsByConditionIf() {
        SqlSession sqlSession = null;
        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            Employee employee = new Employee();
            employee.setId(1);
            employee.setLastName("%x%");
            employee.setGender("3");
            List<Employee> list = mapperDynamicSql.getEmpsByConditionIf(employee);
            System.out.println("list = " + list);
        } finally {
            sqlSession.close();
        }
    }
}
