package com.artur_f.project.controller.customersControllers;


import com.artur_f.project.entity.Customer;
import com.artur_f.project.entity.Employee;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main/customer")
public class CustomerController {

    private final CustomersService customersService;

    public CustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @PostMapping
    public String postCustomer(
            @RequestParam(name = "getByParam", required = false) String getByParam,
            @RequestParam(name = "getBy", required = false) String getBy,
            @RequestParam(name = "sortUp", required = false) String sortUp,
            @RequestParam(name = "sortDown", required = false) String sortDown,
            Model model) {
        System.out.println("getByParam "+getByParam);
        System.out.println("getBy "+getBy);
        System.out.println("sortDown "+sortDown);
        System.out.println("sortUp "+sortUp);
        List<Customer> customerList = new ArrayList<>();
        if (getBy != null) {
            System.out.println("+++++++++++++++++++++++++++");
            customerList = customersService.getCustomerBySmth(getBy, getByParam);
            if (sortUp != null) {
                customerList = customersService.sortCustomer(1, sortUp, customerList);
            } else if (sortDown != null) {
                customerList = customersService.sortCustomer(0, sortDown, customerList);
            }
        }
        model.addAttribute("customerList", customerList);
        model.addAttribute("getByParam", getByParam);
        model.addAttribute("getBy", getBy);
        return "customer";
    }

    @GetMapping
    public String getCustomer(
            @RequestParam(name = "getByParam", required = false) String getByParam,
            @RequestParam(name = "getBy", required = false) String getBy,
            Model model) {
        List<Customer> customerList = new ArrayList<>();
        if (getBy != null) {
            customerList = customersService.getCustomerBySmth(getBy, getByParam);
        }
        model.addAttribute("customerList", customerList);
        model.addAttribute("getByParam", getByParam);
        model.addAttribute("getBy", getBy);
        return "customer";
    }

}
