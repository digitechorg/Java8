package com.digitechorg.java8.basics;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Siva", 101, "active", 2000));
        employeeList.add(new Employee(102, "reddy", 101, "active", 5000));
        employeeList.add(new Employee(103, "raju", 102, "inactive", 6000));
        employeeList.add(new Employee(104, "shivam", 102, "inactive", 4000));
        employeeList.add(new Employee(105, "bob", 103, "active", 3500));
        employeeList.add(new Employee(106, "alice", 103, "inactive", 3500));
        employeeList.add(new Employee(107, "srinu", 104, "active", 3500));

        // write a program to print employee details working in each department


        Map<Integer, List<Employee>> emp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
        // emp.entrySet().forEach(System.out::println);
        // write a program to count employee in each department

        Map<Integer, Long> empCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
       // empCount.entrySet().forEach(System.out::println);

        // Active and Inactive employees in the collection

        Map<String,List<Employee>> empStatus = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus,Collectors.toList()));
       // empStatus.entrySet().forEach(System.out::println);

        // print min/max salary of the employee

        Optional<Employee> minSalary= employeeList.stream().min(Comparator.comparingInt(Employee::getSalary));
       // System.out.println(minSalary);

        Optional<Employee> maxSalary= employeeList.stream().max(Comparator.comparingInt(Employee::getSalary));
       // System.out.println(maxSalary);

        // write a program to find minimum salary of employee from each department

        Map<Integer,Optional<Employee>> minSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        minSalaryByDept.entrySet().forEach(System.out::println);

    }
}
