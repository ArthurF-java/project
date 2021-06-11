package com.artur_f.project.controller.employeeControllers;

import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main/employee/delete")
public class DeleteEmployeeController {

    private EmployeesService employeesService;

    public DeleteEmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    public String deleteEmployee(@RequestParam(name = "empId", required = false) String empId,
           Model model){
        employeesService.deleteEmployee(Long.parseLong(empId));
        return "redirect:/main/employee";
    }

    @GetMapping
    public String deleteEmployeePage(@RequestParam(name = "empId", required = false) String empId,
                                     Model model){
        return "employeeDelete";
    }

}
