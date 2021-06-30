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
    public List <Customer> getCustomerById(long customerId) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where id= :id")
                .setParameter("id", customerId).getResultList();
    }
    @Override
    public List<Customer> getCustomersByName(String customerName) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where name= :name")
                .setParameter("name", customerName).getResultList();
    }

    @Override
    public List<Customer> getCustomersBySurname(String customerSurname) {
       Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where surname= :surname")
                .setParameter("surname", customerSurname).getResultList();
    }

    @Override
    public List<Customer> getCustomersByPhone(String customerPhone) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where phone= :phone")
                .setParameter("phone", customerPhone).getResultList();
    }

    @Override
    public List<Customer> getCustomersByCity(String customerCity) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where cityCustomer= :city")
                .setParameter("city", customerCity).getResultList();
    }

    @Override
    public List<Customer> getCustomersByStreet(String customerStreet) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where streetCustomer= :street")
                .setParameter("street", customerStreet).getResultList();
    }

    @Override
    public List<Customer> getCustomersByHouse(int customersHouse) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where houseCustomer= :house")
                .setParameter("house", customersHouse).getResultList();
    }

    @Override
    public List<Customer> getCustomersByFlat(int customersFlat) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Customer where flatCustomer= :flat")
                .setParameter("flat", customersFlat).getResultList();
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




}
