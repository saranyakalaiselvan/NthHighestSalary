package crackit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthHighestSalary {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "A1", "HR", 200000.0);
        Employee employee1 = new Employee(2, "A2", "Developer", 300000.0);
        Employee employee3 = new Employee(3, "A3", "Developer", 310000.0);
        Employee employee4 = new Employee(4, "A4", "Tester", 200000.0);
        Employee employee5 = new Employee(5, "A1", "Lead", 350000.0);
        Employee employee6 = new Employee(6, "A6", "Tester", 2500000.0);
        Employee employee7 = new Employee(7, "A7", "Lead", 420000.0);
        Employee employee8 = new Employee(8, "A8", "HR", 2500000.0);
        Employee employee9 = new Employee(9, "A5", "Lead", 350000.0);

        List<Employee> employees = Arrays.asList(
                employee1, employee,  employee3, employee4,
                employee5, employee6, employee7,employee8, employee9);

        Map.Entry<Double, List<Employee>> nthHighest = findNthHighest(employees, 2);
        //Employee emp = nthHighest.getValue().stream().sorted(Comparator.comparing(Employee::getEmployeeName)).collect(Collectors.toList()).get(0);
        //System.out.println(emp);
        System.out.println(nthHighest);
    }

    private static Map.Entry<Double, List<Employee>> findNthHighest(List<Employee> employees, int i) {
        Map<Double, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        List<Map.Entry<Double, List<Employee>>> collect1 = collect.entrySet().stream()
                .sorted(Comparator.comparingDouble((Map.Entry<Double, List<Employee>> value) -> value.getKey())
                .reversed()).collect(Collectors.toList());
        return collect1.get(i);
    }
}

/***
 * Group -> based on salary
 * Sort -> descending
 * Pick the 2nd element
 */

