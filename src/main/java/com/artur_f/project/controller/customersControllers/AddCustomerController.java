package com.artur_f.project.controller.customersControllers;

import com.artur_f.project.entity.Customer;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main/customer/add")
public class AddCustomerController {

    CustomersService customersService;

    public AddCustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public String getCustomerAdd(
            @RequestParam(name = "message", required = false) String message,
            Model model) {
        if (message != null) {
            if (message.equals("true")) {
                model.addAttribute("messageSuccess", "Customer Add Successfully");
            } else if (message.equals("false")) {
                model.addAttribute("messageError", "Phone number not unique");
            }
        }
        model.addAttribute("customer", new Customer());
        return "customerAdd";
    }

    @PostMapping
    public String postCustomerAdd(
            @ModelAttribute("customer") Customer customer,
            Model model) {
        String message = "";
        if (customersService.checkCustomerPhone(customer.getPhone())) {
            customersService.saveOrUpdate(customer);
            message = "true";
        } else {
            message = "false";
        }
        model.addAttribute("customer", new Customer());
        return "redirect:/main/customer/add?message=" + message + "";
    }
}
