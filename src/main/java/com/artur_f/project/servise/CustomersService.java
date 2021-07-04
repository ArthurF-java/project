package com.artur_f.project.servise;
import com.artur_f.project.entity.Customer;
import java.util.List;

public interface CustomersService {
    void updateCustomer (Customer customer);
    Customer saveOrUpdate(Customer customer);
    void deleteCustomer(long customerId);


    boolean checkCustomerPhone(String phone);
    boolean checkCustomerId(long customerId);
    boolean checkCustomerForPhoneChange(long customerId, String phone);

    List<Customer> getAllCustomers();
    List<Customer> getCustomerById(long customerId);
    List<Customer> getCustomerBySmth(String getBy, String getByParam);
    List<Customer> getCustomersByName(String customerName);
    List<Customer> getCustomersBySurname(String customerSurname);
    List<Customer> getCustomersByPhone(String customerPhone);
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
    List<Customer> sortCustomer(int checkUpOrDown,String sortBy, List<Customer> customerList);

    List<Customer> sortListCustomersById(List<Customer> list);
    List<Customer> sortListCustomersBySurname(List<Customer> list);
    List<Customer> sortListCustomersByName(List<Customer> list);
    List<Customer> sortListCustomersByPhone(List<Customer> list);
    List<Customer> sortListCustomersByCity(List<Customer> list);
    List<Customer> sortListCustomersByStreet(List<Customer> list);
    List<Customer> sortListCustomersByHouseNumber(List<Customer> list);
    List<Customer> sortListCustomersByFlatNumber(List<Customer> list);

    List<Customer> reverseSortListCustomersById(List<Customer> list);
    List<Customer> reverseSortListCustomersBySurname(List<Customer> list);
    List<Customer> reverseSortListCustomersByName(List<Customer> list);
    List<Customer> reverseSortListCustomersByPhone(List<Customer> list);
    List<Customer> reverseSortListCustomersByCity(List<Customer> list);
    List<Customer> reverseSortListCustomersByStreet(List<Customer> list);
    List<Customer> reverseSortListCustomersByHouseNumber(List<Customer> list);
    List<Customer> reverseSortListCustomersByFlatNumber(List<Customer> list);



}
