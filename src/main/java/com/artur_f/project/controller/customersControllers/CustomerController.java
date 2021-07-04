package com.artur_f.project.controller.customersControllers;

import com.artur_f.project.entity.Customer;
import com.artur_f.project.servise.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main/customer")
@SessionAttributes("customerList")
public class CustomerController {

    private final CustomersService customersService;

    public CustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @ModelAttribute(name = "customerList")
    List<Customer> getCustomerList() {
        return new ArrayList<>();
    }

    @PostMapping
    public String postCustomer(
            @ModelAttribute("customerList") List<Customer> customerList,
            @RequestParam(name = "sortUp", required = false) String sortUp,
            @RequestParam(name = "sortDown", required = false) String sortDown,
            @RequestParam(name = "getAll", required = false) String getAllCustomers,
            Model model) {
        if(customerList!=null){
            if (sortUp != null) {
                customerList = customersService.sortCustomer(1, sortUp,  customerList);
            } else if (sortDown != null) {
                customerList = customersService.sortCustomer(0, sortDown, customerList);
            }else if(getAllCustomers!=null){
                customerList = customersService.getAllCustomers();
            }
        }
        model.addAttribute("customerList", customerList);
        return "customer";
    }

    @GetMapping
    public String getCustomer(
            @ModelAttribute("customerList") List<Customer> customerList,
            @RequestParam(name = "getByParam", required = false) String getByParam,
            @RequestParam(name = "getBy", required = false) String getBy,
            Model model) {
        if (getBy != null) {
            customerList = customersService.getCustomerBySmth(getBy, getByParam);
        } else {
            customerList = new ArrayList<>();
        }
        model.addAttribute("customerList", customerList);
        model.addAttribute("getByParam", getByParam);
        model.addAttribute("getBy", getBy);

        return "customer";
    }

}
