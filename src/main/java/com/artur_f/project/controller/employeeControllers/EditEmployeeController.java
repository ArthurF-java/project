package com.artur_f.project.controller.employeeControllers;

import com.artur_f.project.entity.Employee;
import com.artur_f.project.entity.Role;
import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main/employee/edit")
public class EditEmployeeController {

    private EmployeesService employeesService;

    public EditEmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    public String postEditEmployee(@ModelAttribute("employee") Employee employee,
                               @RequestParam("new_password") String newPassword,
                               Model model) {
        if(newPassword!=null){
        employee.setPassword(employeesService.passwordEncoding(newPassword));
        }
        employeesService.editOrSaveEmployee(employee);
        String empId = String.valueOf(employee.getId());
        return "redirect:/main/employee/edit?empId="+empId+"&message=1";

    }

    @GetMapping
    public String getEditEmployee(@RequestParam(name = "empId", required = false) String empId,
                                  @RequestParam(name = "message", required = false) String message,
                                  Model model) {
        model.addAttribute("messageError", "false");
        model.addAttribute("messageSuccess", "false");
        if (empId != null) {
            if(employeesService.checkEmployeeIdInDb(Long.parseLong(empId))){
                Employee employee = employeesService.getEmployeeById(Long.parseLong(empId));
                model.addAttribute("employee", employee);
            }else {
                model.addAttribute("messageError", "Employee doesn't exist with id "+ empId+ "");
                model.addAttribute("employee", new Employee());
            }
        } else {
            model.addAttribute("employee", new Employee());
        }
        if(message!=null){
            model.addAttribute("messageSuccess", "Employee edit successfully.");
        }
        model.addAttribute("roleMap", employeesService.getMapRole());
        model.addAttribute("accessMap", employeesService.getMapAccess());
        return "employeeEdit";
    }

}
