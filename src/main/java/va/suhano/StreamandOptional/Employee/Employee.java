package va.suhano.StreamandOptional.Employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departament;
    private double salary;


    public Employee(String firstName, String lastName, int departament, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
        this.salary = salary;
    }

    public int getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departament == employee.departament && Double.compare(employee.salary, salary) == 0 && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departament, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departament=" + departament +
                ", salary=" + salary +
                '}';
    }
}



