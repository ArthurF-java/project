package com.artur_f.project.servise.imp;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.entity.Role;
import com.artur_f.project.repository.EmployeesRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeesRepository.getAllEmployee();
    }

    @Override
    public List<Employee> sortById(List<Employee> employees) {
        return employees.stream().sorted((Comparator.comparing(Employee::getId))).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByName(List<Employee> employees) {
        return employees.stream().sorted((Comparator.comparing(Employee::getName))).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByRole(List<Employee> employees) {
        return employees.stream().sorted((Comparator.comparing(Employee::getAuthority))).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByAccess(List<Employee> employees) {
        return employees.stream().sorted((Comparator.comparing(Employee::getEnabled))).collect(Collectors.toList());
    }

    @Override
    public String getMessageRole(Role roleEmployee) {
        if (roleEmployee.equals(Role.ROLE_ADMIN)){
            return "administrator";
        }else  if (roleEmployee.equals(Role.ROLE_SALES)){
            return "sales manager";
        }else if (roleEmployee.equals(Role.ROLE_MEASURER)){
            return "measurer";
        }else if(roleEmployee.equals(Role.ROLE_PRODUCTION)){
            return "production";
        }else return "Error, plz re-enter";
    }

    @Override
    public Map<Integer, String> getMapAccess() {
        Map<Integer, String> accessMap =new HashMap<>();
        accessMap.put(0, "false");
        accessMap.put(1, "true");
        return accessMap;
    }

    @Override
    public Map<Role, String> getMapRole() {
        Map <Role, String> roleMap = new HashMap<>();
        roleMap.put(Role.ROLE_ADMIN, "Administrator");
        roleMap.put(Role.ROLE_SALES, "Sales manager");
        roleMap.put(Role.ROLE_MEASURER, "Measurer");
        roleMap.put(Role.ROLE_PRODUCTION, "Production");
        return roleMap;
    }

    @Override
    public String passwordEncoding(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return "{bcrypt}"+passwordEncoder.encode(password);
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

    @Override
    @Transactional
    public boolean checkEmployeeIdInDb(long empId) {
        return employeesRepository.checkEmployeeIdInDb(empId);
    }

    @Override
    @Transactional
    public Employee editOrSaveEmployee(Employee employee) {
        return employeesRepository.editOrSaveEmployee(employee);
    }

    @Override
    @Transactional
    public boolean checkEmployeeByName(String name) {
        return employeesRepository.checkEmployeeByName(name);
    }


}
