package com.artur_f.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/order")
public class OrderController {

    @PostMapping
    public String getMeasurer(){
        return "order";
    }
}
