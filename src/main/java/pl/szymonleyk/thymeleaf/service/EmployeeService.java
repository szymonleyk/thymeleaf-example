package pl.szymonleyk.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonleyk.thymeleaf.model.Employee;
import pl.szymonleyk.thymeleaf.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void add(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }
}
