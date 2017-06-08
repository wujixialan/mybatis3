package com.zxg.test;

import com.zxg.dao.EmployeeMapperDynamicSql;
import com.zxg.mybatis.Department;
import com.zxg.mybatis.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    @Test
    public void testGetEmpsByConditionTrim() {
        SqlSession sqlSession = null;
        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            Employee employee = new Employee();
            employee.setId(1);
            List<Employee> list = mapperDynamicSql.getEmpsByConditionTrim(employee);
            System.out.println("list = " + list);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmpsByConditionChoose() {
        SqlSession sqlSession = null;

        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            Employee employee = new Employee();
            employee.setId(1);
            employee.setLastName("xia");
            List<Employee> list = mapperDynamicSql.getEmpsByConditionChoose(employee);
            System.out.println("list = " + list);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateEmpsByConditionTrim() {
        SqlSession sqlSession = null;

        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            Employee emp = new Employee();
            emp.setId(1);
            emp.setLastName("33333");
            emp.setEmail("3333333@gmail.com");
            emp.setGender("1");
            mapperDynamicSql.UpdateEmpsByConditionTrim(emp);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmpsByConditionForeach() {
        SqlSession sqlSession = null;

        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            List<Employee> employees = mapperDynamicSql.getEmpsByConditionForeach(list);
            System.out.println("employees = " + employees);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAddEmpsByConditionForeach() {
        SqlSession sqlSession = null;

        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            List<Employee> list = new ArrayList<>();
            list.add(new Employee(null, "xxxx", "dddd@qq.com", "1", new Department(1)));
            list.add(new Employee(null, "wwwww", "wwww@qq.com", "0", new Department(2)));
            list.add(new Employee(null, "aaaaa", "aaaa@qq.com", "0", new Department(1)));

            mapperDynamicSql.addEmps(list);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetEmpInnerParamters() {
        SqlSession sqlSession = null;

        try {
            sqlSession = this.sqlSessionFactory.openSession(true);
            EmployeeMapperDynamicSql mapperDynamicSql = sqlSession.getMapper(EmployeeMapperDynamicSql.class);
            Employee e = new Employee();
            e.setLastName("xia");
            List<Employee> employees = mapperDynamicSql.getEmpInnerParameters(e);
            System.out.println("employees = " + employees.size());
        } finally {
            sqlSession.close();
        }
    }
}
