package com.artur_f.project.repository.imp;

import com.artur_f.project.entity.Customer;
import com.artur_f.project.repository.CustomersRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomersRepositoryImp implements CustomersRepository {

    private final EntityManager entityManager;

    public CustomersRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer editOrSaveCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(long customerId) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Customer where id=:customerId")
                .setParameter("customerId", customerId);
        query.executeUpdate();

    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer ", Customer.class).getResultList();
    }

    @Override
    public List<Customer> getCustomersByName(String customerName) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where name= :name")
                .setParameter("name", customerName).getResultList();
    }

    @Override
    public List<Customer> getCustomersBySurname(String customerSurname) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByCity(String customerCity) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByStreet(String customerStreet) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByAddress(String customerCity, String customerStreet, String customerHome, String customerFlat) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByAddress(String customerCity, String customerStreet, String customerHome) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByAddress(String customerCity, String customerStreet) {
        return null;
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        return null;
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return null;
    }
}
