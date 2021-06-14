package com.artur_f.project.controller.employeeControllers;

import com.artur_f.project.entity.Employee;
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
    public String postDeleteEmployee(@RequestParam(name = "empId", required = false) String empId,
                                     Model model) {
        employeesService.deleteEmployee(Long.parseLong(empId));
        return "redirect:/main/employee";
    }

    @GetMapping
    public String getDeleteEmployee(@RequestParam(name = "empId", required = false) String empId,
                                    Model model) {
        model.addAttribute("message", "false");
        if (empId != null) {
            if(employeesService.checkEmployeeIdInDb(Long.parseLong(empId))){
                Employee employee = employeesService.getEmployeeById(Long.parseLong(empId));
                model.addAttribute("employee", employee);
                model.addAttribute("empAccess", employee.getAccess(employee.getEnabled()));
            }else {
                model.addAttribute("message", "Employee doesn't exist with id "+ empId+ "");
                model.addAttribute("employee", new Employee());
            }
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employeeDelete";
    }

}
