package com.artur_f.project.controller.employeeControllers;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/main/employee")
public class EmployeeController {

    private EmployeesService employeesService;

    public EmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    public String postEmployee(
            @RequestParam(name = "getEmp", required = false) String getEmp,
            @RequestParam(name = "getAllEmp", required = false) String getAllEmp,
            Model model) {
        List<Employee> employees = new ArrayList<>();
        if (getAllEmp != null) {
            employees = employeesService.sortEmployee(getAllEmp);
        }else if(getEmp != null){
            employees.add(employeesService.getEmployeeById(Long.valueOf(getEmp)));
        }
        model.addAttribute("employeeList", employees);
        return "employee";
    }

    @GetMapping
    public  String getEmployee(Model model){
        model.addAttribute("employeeList", employeesService.getAllEmployee());
        return "employee";
    }

}
