package com.artur_f.project.controller;


import com.artur_f.project.entity.Employee;
import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;


@Controller
@RequestMapping({"/main","/"})
@SessionAttributes("userId")
public class MainController {

    private EmployeesService employeesService;

    public MainController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @ModelAttribute(name = "userId")
    public long idEmployee(Principal principal){
        return employeesService.getEmployeeIdByName(principal.getName());
    }


    @GetMapping
    public String getMain(Model model, @ModelAttribute("userId") long userId){
        Employee employee = employeesService.getEmployeeById(userId);
        model.addAttribute("employeeName", employee.getName());
        model.addAttribute("employeeRole", employeesService.getMessageRole(employee.getAuthority()));
        return "main";
    }

}
