package com.digitechorg.java8.collectors;

import java.util.*;
import java.util.stream.Collectors;


// practice Map reduce, streams, Flatmap

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 13, "History", 83.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));
        studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
        studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
        studentList.add(new Student("Mitshu", 18, "History", 73.5));
        studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
        studentList.add(new Student("Harry", 20, "History", 71.9));

        List<Student> first3names =studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList());
        //System.out.println(first3names);

         Set<String> setOfSubjects= studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
        //System.out.println(setOfSubjects);

        Map<String,Double> mapped = studentList.stream().collect(Collectors.toMap(Student::getName,Student::getPercentage));
       System.out.println(mapped);

       LinkedList<Student> studentLinkedList=  studentList.stream().limit(3).collect(Collectors.toCollection(LinkedList::new));
        //System.out.println(studentLinkedList);

      String student=  studentList.stream().map(Student::getName).collect(Collectors.joining(" , "));
       // System.out.println(student);

        Long count =studentList.stream().collect(Collectors.counting());
       // System.out.println(count);

   Optional<Double> highestPercentage = studentList.stream().map(Student::getPercentage).collect(Collectors.minBy(Comparator.naturalOrder()));
       // System.out.println(highestPercentage);

     DoubleSummaryStatistics summing= studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
       // System.out.println(" Max : "+summing.getMax());
       // System.out.println(" Min : "+summing.getMin());
       // System.out.println("Sum : "+summing.getSum());
       // System.out.println("Average : "+summing.getAverage());
       // System.out.println("Count : "+summing.getCount());

        // grouping by
Map<String, List<Student>> groupingBySubject= studentList.stream().collect(Collectors.groupingBy(Student::getSubject));
        //System.out.println(groupingBySubject);

    }
}
