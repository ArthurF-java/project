package com.artur_f.project.controller.employeeControllers;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main/employee/edit")
public class EditEmployeeController {

    private EmployeesService employeesService;

    public EditEmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    public String editEmployee(@RequestParam(name = "empId", required = false) String empId,
                               Model model) {
        if (empId != null) {
            Employee employee = employeesService.getEmployeeById(Long.parseLong(empId));
            model.addAttribute("employee", employee);
        }
        return "employeeEdit";
    }
}
