package com.digitechorg.java8.reality;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExampleTestOperationsOnIntArray {

    public static void main(String[] args) {
        int[] array = {2, 6, 3, 2, 5, 8, 3, 10, 15};

        findDuplicatesInArray(array);
        removeDuplicatesInArray(array);
        findEvenNumbers(array);
        findNumbersStartWithOne(array);
        findFirstElement(array);
        findTotalNoOfElements(array);
        findMaxVal(array);
        sortedArray(array);
    }

    public static void findDuplicatesInArray(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = Arrays.stream(array).filter(i -> !uniqueElements.add(i)).boxed().collect(Collectors.toSet());
        System.out.println(duplicateElements);


    }

    public static void removeDuplicatesInArray(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> filteredSet = Arrays.stream(array).filter(i -> uniqueElements.add(i)).boxed().collect(Collectors.toSet());
        System.out.println(filteredSet);
    }


    public static void findEvenNumbers(int[] array) {
        List<Integer> evenList = Arrays.stream(array).filter(i -> i % 2 == 0).boxed().distinct().collect(Collectors.toList());
        System.out.println(evenList);
    }

    public static void findNumbersStartWithOne(int[] array) {
        List<String> numbersWithOne = Arrays.stream(array).boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1")) //Convert integer to String
                .collect(Collectors.toList());
        System.out.println(numbersWithOne);
    }

    public static void findFirstElement(int[] array) {
        Integer findFirst = Arrays.stream(array).findFirst().getAsInt();
        System.out.println(findFirst);
    }

    public static void findTotalNoOfElements(int[] array) {
        long count = Arrays.stream(array).count();
        System.out.println(count);
    }

    public static void findMaxVal(int [] array){
        OptionalInt count = Arrays.stream(array).max();
        System.out.println(count);
    }

    public static void sortedArray(int [] array){
       List<Integer> sortedArray = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        System.out.println(sortedArray);
    }

}
