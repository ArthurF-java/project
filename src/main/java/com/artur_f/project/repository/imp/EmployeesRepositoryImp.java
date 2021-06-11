package com.artur_f.project.repository.imp;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.entity.Role;
import com.artur_f.project.repository.EmployeesRepository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class EmployeesRepositoryImp implements EmployeesRepository {

    private final EntityManager entityManager;

    public EmployeesRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long getEmployeeIdByName(String empName){
        Session session = entityManager.unwrap(Session.class);
        Employee employee = (Employee) session.createQuery("from Employee where name= :name")
                .setParameter("name", empName)
                .getSingleResult();
        return  employee.getId();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
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
    public Employee getEmployee(long empId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, empId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Employee ", Employee.class);
        List<Employee> employees= query.getResultList();
        return employees;
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
    public void deleteEmployee(long empId) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee where id=:empId");
        query.setParameter("empId", empId);
        query.executeUpdate();
    }


}
