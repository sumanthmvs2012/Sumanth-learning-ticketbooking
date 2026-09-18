package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee
{

    String name;
    double salary;

    Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }
}

public class LambdaDemo
{
    public static void main(String[] args)
    {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Sumanth", 8000));
        employeeList.add(new Employee("Vijay", 600));
        employeeList.add(new Employee("Sravan", 700));

        employeeList.forEach(employee -> {
            if(employee.salary > 5000)
            {
                System.out.println(employee.name);
            }
        });

    }

}
