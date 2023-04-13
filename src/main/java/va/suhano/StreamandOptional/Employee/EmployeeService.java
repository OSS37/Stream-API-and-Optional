package va.suhano.StreamandOptional.Employee;


import org.springframework.stereotype.Service;
import va.suhano.StreamandOptional.DepartamentAndSalary.DepartamentAndSalaryService;
import va.suhano.StreamandOptional.exception.EmployeeAlreadyAddedException;
import va.suhano.StreamandOptional.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeService extends DepartamentAndSalaryService {
    private final Map<String, Employee> employees = new HashMap<>();
    private String key (String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public EmployeeService(EmployeeService employeeService) {
        super(employeeService);
    }

    public Employee add(String firstName, String lastName, int departament, double salary) {
        Employee person = new Employee(firstName, lastName, departament, salary);
        if (employees.containsKey(person.getFullName())) {
            throw new EmployeeAlreadyAddedException("Добавляемый сотрудник уже есть в списке");
        }
        employees.put(person.getFullName(), person);
        return person;
    }

    public Employee remove (String firstName, String lastName) {
        //Employee person = new Employee(firstName, lastName);
        String key = key(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    public Employee find (String firstName, String lastName) {
        //Employee person = new Employee(firstName, lastName);
        String key = key(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(employees.get(key));
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    public Collection <Employee> showAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
