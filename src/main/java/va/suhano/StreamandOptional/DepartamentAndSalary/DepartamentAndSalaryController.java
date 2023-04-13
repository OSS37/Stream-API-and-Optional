package va.suhano.StreamandOptional.DepartamentAndSalary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import va.suhano.StreamandOptional.Employee.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartamentAndSalaryController {
    private final DepartamentAndSalaryService service;

    public DepartamentAndSalaryController(DepartamentAndSalaryService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Employee MaxSalaryInDepartment(@RequestParam("departmentId") int departmentId) {
        return service.MaxSalaryInDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee MinSalaryInDepartment(@RequestParam("departmentId") int departmentId) {
        return service.MinSalaryInDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> EmployeesInDepartment(@RequestParam("departmentId") int departmentId) {
        return service.EmployeesInDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> AllEmployees() {
        return service.AllEmployees();
    }
}
