package com.artur_f.project.repository;

import com.artur_f.project.entity.Customer;

import java.util.List;

public interface CustomersRepository {
    Customer editOrSaveCustomer(Customer customer);
    void deleteCustomer(long customerId);

    List<Customer> getAllCustomers();
    List<Customer> getCustomerById(long customerId);
    List<Customer> getCustomersByName(String customerName);
    List<Customer> getCustomersBySurname(String customerSurname);
    List<Customer> getCustomersByPhone(String customerPhone);
    List<Customer> getCustomersByCity(String customerCity);
    List<Customer> getCustomersByStreet(String customerStreet);
    List<Customer> getCustomersByHouse(int customerHouse);
    List<Customer> getCustomersByFlat(int customerFlat);

    List<Customer> getCustomersByAddress(String customerCity, String customerStreet
            , String customerHome, String customerFlat);
    List<Customer> getCustomersByAddress(String customerCity, String customerStreet
            , String customerHome);
    List<Customer> getCustomersByAddress(String customerCity, String customerStreet);

}
