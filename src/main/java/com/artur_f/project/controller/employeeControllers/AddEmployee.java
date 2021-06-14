package com.artur_f.project.controller.employeeControllers;


import com.artur_f.project.entity.Employee;
import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main/employee/add")
public class AddEmployee {

    private EmployeesService employeesService;

    public AddEmployee(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public String getAddEmployeePage(@RequestParam(name = "message", required = false) String message,
                                     Model model) {
        model.addAttribute("messageSuccess", "false");
        model.addAttribute("messageSuccess", "false");
        model.addAttribute("employee", new Employee());
        model.addAttribute("roleMap", employeesService.getMapRole());
        model.addAttribute("accessMap", employeesService.getMapAccess());
        if (message != null) {
            if (message.equals("true")) {
                model.addAttribute("messageSuccess", "Employee add Successfully");
            }else if (message.equals("false")) {
                model.addAttribute("messageError", "passwords are not the same");
            } else {
                model.addAttribute("messageError", "Name isn`t unique");
            }
        }
        return "employeeAdd";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              Model model) {
        String message = "false";
        if (employeesService.checkEmployeeByName(employee.getName())) {
            if (employee.getPassword().equals(employee.getPasswordConfirm())) {
                employee.setPassword(employeesService.passwordEncoding(employee.getPassword()));
                employeesService.editOrSaveEmployee(employee);
                message = "true";
            }
        }else message = "badname";

        return "redirect:/main/employee/add?message=" + message + "";
    }
}
