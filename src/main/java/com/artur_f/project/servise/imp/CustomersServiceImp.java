package com.artur_f.project.servise.imp;

import com.artur_f.project.entity.Customer;
import com.artur_f.project.repository.CustomersRepository;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersServiceImp implements CustomersService {

    private final CustomersRepository customersRepository;

    public CustomersServiceImp(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customersRepository.updateCustomer(customer);
    }

    @Override
    @Transactional
    public Customer saveOrUpdate(Customer customer) {
        return customersRepository.saveOrUpdate(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(long customerId) {
        customersRepository.deleteCustomer(customerId);
    }

    @Override
    @Transactional
    public boolean checkCustomerPhone(String phone) {
        return customersRepository.checkCustomerPhone(phone);
    }

    @Override
    @Transactional
    public boolean checkCustomerId(long customerId) {
        return customersRepository.checkCustomerId(customerId);
    }

    @Override
    @Transactional
    public boolean checkCustomerForPhoneChange(long customerId, String phone) {
        return customersRepository.checkCustomerForPhoneChange(customerId, phone);
    }

    @Override
    @Transactional
    public List <Customer> getCustomerById(long customerId) {
        return customersRepository.getCustomerById(customerId);
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customersRepository.getAllCustomers();
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByName(String customerName) {
        return customersRepository.getCustomersByName(customerName);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersBySurname(String customerSurname) {
        return customersRepository.getCustomersBySurname(customerSurname);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByPhone(String customerPhone) {
        return customersRepository.getCustomersByPhone(customerPhone);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByCity(String customerCity) {
        return customersRepository.getCustomersByCity(customerCity);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByStreet(String customerStreet) {
        return customersRepository.getCustomersByStreet(customerStreet);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByHouse(int customerHouse) {
        return customersRepository.getCustomersByHouse(customerHouse);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByFlat(int customerFlat) {
        return customersRepository.getCustomersByFlat(customerFlat);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByAddress(String customerCity, String customerStreet, String customerHome, String customerFlat) {
        return null;
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByAddress(String customerCity, String customerStreet, String customerHome) {
        return null;
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByAddress(String customerCity, String customerStreet) {
        return null;
    }


    @Override
    @Transactional
    public List<Customer> getCustomerBySmth(String getBy, String getByParam) {
        List<Customer> customerList = new ArrayList<>();
        if (getBy.equals("id")) {
            try{
            return getCustomerById(Long.parseLong(getByParam));}
            catch (NumberFormatException e){
                return customerList;
            }
        } else if (getBy.equals("surname")) {
            return getCustomersBySurname(getByParam);
        } else if (getBy.equals("name")) {
            return getCustomersByName(getByParam);
        } else if (getBy.equals("phone")) {
            return getCustomersByPhone(getByParam);
        } else if (getBy.equals("city")) {
            return getCustomersByCity(getByParam);
        } else if (getBy.equals("street")) {
            return getCustomersByStreet(getByParam);
        } else if (getBy.equals("house")) {
            try{
                return getCustomersByHouse(Integer.parseInt(getByParam));}
            catch (NumberFormatException e){
                return customerList;
            }
        } else if (getBy.equals("flat")) {
            try{
                return getCustomersByFlat(Integer.parseInt(getByParam));}
            catch (NumberFormatException e){
                return customerList;
            }

        }
        return customerList;
    }

    @Override
    public List<Customer> sortCustomer(int checkUpOrDown, String sortBy, List<Customer> customerList) {
        if (checkUpOrDown > 0) {
            if(sortBy.equals("id")){
               return sortListCustomersById(customerList);
            }else if(sortBy.equals("surname")){
                return sortListCustomersBySurname(customerList);
            }else if(sortBy.equals("name")){
                return sortListCustomersByName(customerList);
            }else if(sortBy.equals("phone")){
                return sortListCustomersByPhone(customerList);
            }else if(sortBy.equals("city")){
                return sortListCustomersByCity(customerList);
            }else if(sortBy.equals("street")){
                return sortListCustomersByStreet(customerList);
            }else if(sortBy.equals("house")){
                return sortListCustomersByHouseNumber(customerList);
            }else if(sortBy.equals("flat")){
                return sortListCustomersByFlatNumber(customerList);
            }
        } else {
            if(sortBy.equals("id")){
                return reverseSortListCustomersById(customerList);
            }else if(sortBy.equals("surname")){
                return reverseSortListCustomersBySurname(customerList);
            }else if(sortBy.equals("name")){
                return reverseSortListCustomersByName(customerList);
            }else if(sortBy.equals("phone")){
                return reverseSortListCustomersByPhone(customerList);
            }else if(sortBy.equals("city")){
                return reverseSortListCustomersByCity(customerList);
            }else if(sortBy.equals("street")){
                return reverseSortListCustomersByStreet(customerList);
            }else if(sortBy.equals("house")){
                return reverseSortListCustomersByHouseNumber(customerList);
            }else if(sortBy.equals("flat")){
                return reverseSortListCustomersByFlatNumber(customerList);
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> sortListCustomersById(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersBySurname(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getSurname)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersByName(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersByPhone(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getPhone)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersByCity(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getCityCustomer)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersByStreet(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getStreetCustomer)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersByHouseNumber(List<Customer> list) {
        return list.stream().sorted(Comparator.comparing(Customer::getHouseCustomer)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> sortListCustomersByFlatNumber(List<Customer> list) {
        return list.stream().sorted(Comparator.comparingInt(Customer::getFlatCustomer)).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersById(List<Customer> list) {
        return list.stream().sorted((s1,s2)->Long.compare(s2.getId(),s1.getId())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersBySurname(List<Customer> list) {
        return list.stream().sorted((s1,s2)->s2.getSurname().compareTo(s1.getSurname())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersByName(List<Customer> list) {
        return list.stream().sorted((s1,s2)->s2.getName().compareTo(s1.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersByPhone(List<Customer> list) {
        return list.stream().sorted((s1,s2)->s2.getPhone().compareTo(s1.getPhone())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersByCity(List<Customer> list) {
        return list.stream().sorted((s1,s2)->s2.getCityCustomer().compareTo(s1.getCityCustomer())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersByStreet(List<Customer> list) {
        return list.stream().sorted((s1,s2)->s2.getStreetCustomer().compareTo(s1.getStreetCustomer())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersByHouseNumber(List<Customer> list) {
        return list.stream().sorted((s1,s2)->Integer.compare(s2.getHouseCustomer(), s1.getHouseCustomer())).collect(Collectors.toList());
    }

    @Override
    public List<Customer> reverseSortListCustomersByFlatNumber(List<Customer> list) {
        return list.stream().sorted((s1,s2)->Integer.compare(s2.getFlatCustomer(), s1.getFlatCustomer())).collect(Collectors.toList());
    }
}
