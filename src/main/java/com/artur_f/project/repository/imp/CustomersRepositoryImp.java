package com.artur_f.project.repository.imp;

import com.artur_f.project.entity.Customer;
import com.artur_f.project.repository.CustomersRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class CustomersRepositoryImp  implements CustomersRepository  {


    private final EntityManager entityManager;
//    SimpleJpaRepository simpleJpaRepository;

    public CustomersRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    public CustomersRepositoryImp(EntityManager entityManager, SimpleJpaRepository simpleJpaRepository) {
//        this.entityManager = entityManager;
//        this.simpleJpaRepository = simpleJpaRepository;
//    }

    @Override
    public void saveCustomerSimpleJPA(Customer customer) {
//        simpleJpaRepository.save(customer);
//        Session session = entityManager.unwrap(Session.class);
//        session.update(customer);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
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
    public boolean checkCustomerId(long customerId) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class, customerId);
        if (customer == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkCustomerPhone(String phone) {
        Session session = entityManager.unwrap(Session.class);
        try {
            Customer customer = (Customer) session.createQuery("from  Customer  where  phone=:phone")
                    .setParameter("phone", phone).getSingleResult();
            return false;
        }catch (NoResultException e ){
            return true;
        }
    }

    @Override
    public boolean checkCustomerForPhoneChange(long customerId, String phone) {
        Session session = entityManager.unwrap(Session.class);

        Customer customer = session.get(Customer.class, customerId);
        if(customer.getPhone().equals(phone)){
            return true;
        }else {
            return false;
        }
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
