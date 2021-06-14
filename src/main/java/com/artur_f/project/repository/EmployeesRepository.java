package com.artur_f.project.repository;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.entity.Role;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeesRepository {

    long getEmployeeIdByName(String empName);
    Employee getEmployeeById(long id);
    Employee getEmployee(long empId);
    List<Employee> getAllEmployee();
    void deleteEmployee(long empId);
    boolean checkEmployeeIdInDb(long empId);
    boolean checkEmployeeByName(String name);
    Employee editOrSaveEmployee(Employee employee);

}
