package com.artur_f.project.controller.customersControllers;


import com.artur_f.project.entity.Customer;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/main/customer/delete")
public class DeleteCustomerController {

    private final CustomersService customersService;

    public DeleteCustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public String getDeleteCustomer(
            @RequestParam(name = "customerId", required = false) String customerId,
            @RequestParam(name = "message", required = false) String messageFromPost,
            Model model) {
        if (customerId != null) {
            if (customersService.checkCustomerId(Long.parseLong(customerId))) {
                List<Customer> customerList = customersService.getCustomerById(Long.parseLong(customerId));
                model.addAttribute("customer", customerList.get(0));
            } else {
                model.addAttribute("customer", new Customer());
                model.addAttribute("message", "Customer with id = " + customerId + " doesn't exist");
            }

        } else {
            model.addAttribute("customer", new Customer());
        }
        if (messageFromPost != null) {
            model.addAttribute("messageFromPost", "Customer delete successfully");
        }
        return "customerDelete";
    }

    @PostMapping
    public String postDeleteCustomer(
            @RequestParam(name = "customerId", required = false) String customerId,
            Model model) {
        customersService.deleteCustomer(Long.parseLong(customerId));
        return "redirect:/main/customer/delete?&message=true";
    }
}
