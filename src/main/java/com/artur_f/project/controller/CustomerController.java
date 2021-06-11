package com.artur_f.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/customer")
public class CustomerController {

    @PostMapping
    public String postCustomer(){
        return "customer";
    }
}
