package com.artur_f.project.controller.customersControllers;


import com.artur_f.project.entity.Customer;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main/customer/edit")
public class EditCustomerController {

    CustomersService customersService;

    public EditCustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public String getEditCustomer(
            @RequestParam(name = "customerId", required = false) String customerId,
            @RequestParam(name = "message", required = false) String messageFromPost,
            Model model) {
        if (customerId != null) {
            if (customersService.checkCustomerId(Long.parseLong(customerId))) {
                List<Customer> customerList = customersService.getCustomerById(Long.parseLong(customerId));
                model.addAttribute("customer", customerList.get(0));
            } else {
                model.addAttribute("customer", new Customer());
                model.addAttribute("message" , "Customer with id = "+ customerId+" doesn't exist");
            }
        }else {
            model.addAttribute("customer", new Customer());
        }
        if(messageFromPost!=null){
            model.addAttribute("message", "Phone number not unique");
        }
        return "customerEdit";
    }

    @PostMapping
    public String postEditCustomer(
            @RequestParam(name = "customerPhone", required = false) String customerPhone,
            @ModelAttribute("customer") Customer customer){
        if(customerPhone.equals(customer.getPhone())){
            customersService.saveOrUpdate(customer);
//        if(customersService.checkCustomerForPhoneChange(customer.getId(), customer.getPhone())){
//            customersService.saveCustomerSimpleJPA(customer);
        }else {
            if (customersService.checkCustomerPhone(customer.getPhone())){
                customersService.saveOrUpdate(customer);
//                customersService.saveCustomerSimpleJPA(customer);
            }else {
                return "redirect:/main/customer/edit?customerId=" + customer.getId() + "&message=true";
            }
        }

        return "redirect:/main/customer/edit?customerId=" + customer.getId() + "";
    }
}
