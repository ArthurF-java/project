package com.artur_f.project.servise;

import com.artur_f.project.entity.Customer;

import java.util.List;

public interface CustomersService {
    Customer editOrSaveCustomer(Customer customer);
    void deleteCustomer(long customerId);
    List<Customer> getAllCustomers();
    List<Customer> getCustomerBySmth(String getBy, String getByParam);
    List<Customer> getCustomersByName(String customerName);
    List<Customer> getCustomersBySurname(String customerSurname);
    List<Customer> getCustomersByCity(String customerCity);
    List<Customer> getCustomersByStreet(String customerStreet);
    List<Customer> getCustomersByHouse(int customerHouse);
    List<Customer> getCustomersByFlat(int customerFlat);
    // Get customers by address
    List<Customer> getCustomersByAddress(String customerCity, String customerStreet
            , String customerHome, String customerFlat);
    List<Customer> getCustomersByAddress(String customerCity, String customerStreet
            , String customerHome);
    List<Customer> getCustomersByAddress(String customerCity, String customerStreet);
    //Sort customers
    List<Customer> sortCustomer(String sortBy);
    List<Customer> sortListCustomersById(List<Customer> list);
    List<Customer> sortListCustomersBySurname(List<Customer> list);
    List<Customer> sortListCustomersByName(List<Customer> list);
    List<Customer> sortListCustomersByPhone(List<Customer> list);
    List<Customer> sortListCustomersByCity(List<Customer> list);
    List<Customer> sortListCustomersByStreet(List<Customer> list);
    List<Customer> sortListCustomersByHomeNumber(List<Customer> list);

    Customer getCustomerByPhone(String phone);
    Customer getCustomerById(long customerId);
}
