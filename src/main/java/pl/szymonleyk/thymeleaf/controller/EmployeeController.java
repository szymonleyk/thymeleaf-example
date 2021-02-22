package pl.szymonleyk.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymonleyk.thymeleaf.model.Employee;
import pl.szymonleyk.thymeleaf.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees",employees);
        return "employees";
    }

    @GetMapping("/add-employee")
    public String addEmployeeForm(){
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete-employee")
    public String deleteEmployee(@ModelAttribute Employee employee){
        employeeService.delete(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit-employee/{id}")
    public String editEmployee(@PathVariable int id, Model model){
        Optional<Employee> employee = employeeService.getById(id);
        if(employee.isPresent()){
            // wyświetl formualrz
            model.addAttribute("employee", employee.get());
            return "edit-employee";
        } else {
            return "redirect:/employees";
        }
    }
}
