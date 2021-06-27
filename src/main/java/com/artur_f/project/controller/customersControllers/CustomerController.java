package com.artur_f.project.controller.customersControllers;


import com.artur_f.project.entity.Customer;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam(name = "sortBy", required = false) String sortBy,
            @RequestParam(name = "getByParam", required = false) String getByParam,
            @RequestParam(name = "getBy", required = false) String getBy,
            Model model) {
        List<Customer> customerList = new ArrayList<>();
        if (getBy != null) {
            customerList = customersService.getCustomerBySmth(getBy, getByParam);
        } if (sortBy != null) {
            customerList = customersService.sortCustomer(sortBy);
        }
            model.addAttribute("customerList", customerList);
        return "customer";
    }

    @GetMapping
    public String getCustomer(Model model) {
        model.addAttribute("customerList", customersService.getAllCustomers());
        return "customer";
    }
}
