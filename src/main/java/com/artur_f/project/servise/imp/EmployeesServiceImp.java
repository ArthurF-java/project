package com.artur_f.project.servise.imp;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.entity.Role;
import com.artur_f.project.repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServiceImp implements com.artur_f.project.servise.EmployeesService {

    private final EmployeesRepository employeesRepository;

    public EmployeesServiceImp(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    @Transactional
    public long getEmployeeIdByName(String name) {
        return employeesRepository.getEmployeeIdByName(name);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(long id) {
        return employeesRepository.getEmployeeById(id);
    }

    @Override
    public String getMessageRole(Role roleEmployee) {
        return employeesRepository.getMessageRole(roleEmployee);
    }

    @Override
    @Transactional
    public Employee getEmployee(long empId) {
        return employeesRepository.getEmployeeById(empId);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeesRepository.getAllEmployee();
    }

    @Override
    public List<Employee> sortById(List<Employee> employees) {
        return employeesRepository.sortById(employees);
    }

    @Override
    public List<Employee> sortByName(List<Employee> employees) {
        return employeesRepository.sortByName(employees);
    }

    @Override
    public List<Employee> sortByRole(List<Employee> employees) {
        return employeesRepository.sortByRole(employees);
    }

    @Override
    public List<Employee> sortByAccess(List<Employee> employees) {
        return employeesRepository.sortByAccess(employees);
    }

    @Override
    @Transactional
    public List<Employee> sortEmployee(String check) {
        if(check.equals("1")){
            return  getAllEmployee();
        }else if (check.equals("2")){
            return sortById(getAllEmployee());
        }else if (check.equals("3")){
           return sortByName(getAllEmployee());
        }else if (check.equals("4")){
            return sortByRole(getAllEmployee());
        }else if (check.equals("5")){
            return sortByAccess(getAllEmployee());
        }else return  new ArrayList<>();
    }

    @Override
    @Transactional
    public void deleteEmployee(long empId) {
        employeesRepository.deleteEmployee(empId);
    }
}
