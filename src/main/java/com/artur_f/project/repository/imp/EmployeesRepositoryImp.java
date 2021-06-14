package com.artur_f.project.repository.imp;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.repository.EmployeesRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeesRepositoryImp implements EmployeesRepository {

    private final EntityManager entityManager;

    public EmployeesRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long getEmployeeIdByName(String empName) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = (Employee) session.createQuery("from Employee where name= :name")
                .setParameter("name", empName)
                .getSingleResult();
        return employee.getId();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
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
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public void deleteEmployee(long empId) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee where id=:empId");
        query.setParameter("empId", empId);
        query.executeUpdate();
    }

    @Override
    public boolean checkEmployeeByName(String name) {
        Session session = entityManager.unwrap(Session.class);
        try {
            Employee employee = (Employee) session.createQuery("from  Employee  where  name=:name")
                    .setParameter("name", name).getSingleResult();
            return false;
        }catch (NoResultException e ){
            return true;
        }
    }

    @Override
    public boolean checkEmployeeIdInDb(long empId) {
        if (getEmployeeById(empId) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Employee editOrSaveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee;
    }


}
