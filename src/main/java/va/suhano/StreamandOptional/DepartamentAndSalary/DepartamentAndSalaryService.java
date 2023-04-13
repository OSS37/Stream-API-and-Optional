package va.suhano.StreamandOptional.DepartamentAndSalary;

import org.springframework.stereotype.Service;
import va.suhano.StreamandOptional.Employee.Employee;
import va.suhano.StreamandOptional.Employee.EmployeeService;
import va.suhano.StreamandOptional.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartamentAndSalaryService {

    //Инжекция сервиса EmployeeService в DepartamentAndSalaryService
    private final EmployeeService employeeService;

    public DepartamentAndSalaryService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    //Стрим для поиска сотрудника с максимальной зарплатой в департаменте
    public Employee MaxSalaryInDepartment(int department) {
        return employeeService.showAll().stream()
                .filter(employees -> employees.getDepartament() == department)
                .max(Comparator.comparingDouble(employees -> employees.getSalary()))
                //.max(Comparator.comparingDouble(Employee::getSalary)) то же самое, что и строка выше
                .orElseThrow((RuntimeException::new));
    }

    //Стрим для поиска сотрудника с минимальной зарплатой в департаменте
    public Employee MinSalaryInDepartment (int department) {
        return employeeService.showAll().stream()
                .filter(employees -> employees.getDepartament() == department)
                .min(Comparator.comparingDouble(employees -> employees.getSalary()))
                .orElseThrow((RuntimeException::new));
    }

    //Стрим для поиска сотрудников конкретного отдела
    public List<Employee> EmployeesInDepartment(int department) {
        return employeeService.showAll().stream()
                .filter(employees -> employees.getDepartament() == department)
                .collect(Collectors.toList());
    }
    //Список всех сотрудников с разделением по отделам
    public Map<Integer, List<Employee>> AllEmployees() {
        return employeeService.showAll().stream()
                .collect(Collectors.groupingBy(employees -> employees.getDepartament()));
    }

}
