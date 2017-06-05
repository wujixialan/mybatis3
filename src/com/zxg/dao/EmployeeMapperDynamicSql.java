package com.zxg.dao;

import com.zxg.mybatis.Employee;

import java.util.List;

/**
 * Created by zxg on 2017/6/5.
 */
public interface EmployeeMapperDynamicSql {
    public List<Employee> getEmpsByConditionIf(Employee employee);
}
