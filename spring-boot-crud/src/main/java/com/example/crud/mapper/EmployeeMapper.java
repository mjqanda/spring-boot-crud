package com.example.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.crud.model.Employee;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id} LIMIT 1")
    @Results(id = "employeeResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "dob", column = "dob"),
            @Result(property = "department", column = "department"),
            @Result(property = "salary", column = "salary")
    })
    Employee getEmployeeById(Integer id);

    @Select("SELECT * FROM employee order by id")
    @ResultMap("employeeResultMap")
    List<Employee> getAllEmployee(String orderBy, String order);

    @Select("SELECT MAX(id) FROM employee")
    Integer getLatestEmployeeId();

    @Insert("""
            INSERT INTO employee (name, dob, department, salary)
            VALUES (#{name}, #{dob}, #{department}, #{salary}) """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createEmployee(Employee employee);

    @Update("""
            UPDATE employee
            SET name = #{name}
                ,dob = #{dob}
                ,department = #{department}
                ,salary = #{salary}
            WHERE id = #{id} """)
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmployee(Integer id);

}