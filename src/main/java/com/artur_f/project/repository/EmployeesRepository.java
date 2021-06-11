package com.artur_f.project.repository;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.entity.Role;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository {

    long getEmployeeIdByName(String empName);
    Employee getEmployeeById(long id);
    String getMessageRole(Role roleEmployee);
    Employee getEmployee(long empId);
    List<Employee> getAllEmployee();
    List<Employee> sortById(List<Employee> employees);
    List<Employee> sortByName(List<Employee> employees);
    List<Employee> sortByRole(List<Employee> employees);
    List<Employee> sortByAccess(List<Employee> employees);
    void deleteEmployee(long empId);

}
