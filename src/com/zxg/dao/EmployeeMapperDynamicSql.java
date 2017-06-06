package com.zxg.dao;

import com.zxg.mybatis.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zxg on 2017/6/5.
 */
public interface EmployeeMapperDynamicSql {
    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void UpdateEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);

}
