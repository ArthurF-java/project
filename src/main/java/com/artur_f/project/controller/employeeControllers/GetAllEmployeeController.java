package com.artur_f.project.controller.employeeControllers;


import com.artur_f.project.servise.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main/employee/getallemployees")
public class GetAllEmployeeController {

    private EmployeesService employeesService;

    public GetAllEmployeeController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @RequestMapping
    public String getAllEmployee(Model model) {
        model.addAttribute("employees", employeesService.getAllEmployee());
        model.addAttribute("employee", employeesService.getEmployeeById(1));
        model.addAttribute("name", "123");
        System.out.println(model.getAttribute("employees"));
        return "redirect:/main/employee";
    }

}
