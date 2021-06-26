package com.artur_f.project.servise.imp;

import com.artur_f.project.entity.Customer;
import com.artur_f.project.repository.CustomersRepository;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersServiceImp implements CustomersService {

    private final CustomersRepository customersRepository;

    public CustomersServiceImp(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public Customer editOrSaveCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(long customerId) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public List<Customer> getCustomersByName(String customerName) {
        return null;
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
    public List<Customer> sortCustomer(String sortBy) {
        return null;
    }

    @Override
    @Transactional
    public List<Customer> getCustomerBySmth(String getBy, String getByParam) {
        List <Customer> customerList = new ArrayList<>();
        if(getBy.equals("id")){
            customerList.add(getCustomerById(Long.valueOf(getByParam)));
            return  customerList;
        }else if(getBy.equals("surname")){
            return getCustomersBySurname(getByParam);
        }else if(getBy.equals("name")){
            return getCustomersByName(getByParam);
        }else if(getBy.equals("phone")){
            customerList.add(getCustomerByPhone(getByParam));
            return  customerList;
        }else if(getBy.equals("city")){
            return getCustomersByCity(getByParam);
        }else if(getBy.equals("street")){
            return getCustomersByStreet(getByParam);
        }else if(getBy.equals("house")){
            return getCustomersByHouse(Integer.valueOf(getByParam));
        }else if(getBy.equals("flat")){
            return getCustomersByFlat(Integer.valueOf(getByParam));
        }return customerList;
    }

    @Override
    public List<Customer> getCustomersByHouse(int customerHouse) {
        return null;
    }

    @Override
    public List<Customer> getCustomersByFlat(int customerFlat) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersById(List<Customer> list) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersBySurname(List<Customer> list) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersByName(List<Customer> list) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersByPhone(List<Customer> list) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersByCity(List<Customer> list) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersByStreet(List<Customer> list) {
        return null;
    }

    @Override
    public List<Customer> sortListCustomersByHomeNumber(List<Customer> list) {
        return null;
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        return null;
    }

    @Override
    @Transactional
    public Customer getCustomerById(long customerId) {
        return customersRepository.getCustomerById(customerId);
    }
}
