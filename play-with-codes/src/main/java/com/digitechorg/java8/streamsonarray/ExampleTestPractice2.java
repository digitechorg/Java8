package com.digitechorg.java8.streamsonarray;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleTestPractice2 {

    public static void main(String[] args) {
        findOccurancesOfChars("apple");
    }

    public static void findOccurancesOfChars(String str){
        List<String> list = Arrays.asList(str);

        Map<Character,Long> mapped = list.stream().flatMap(x->x.chars().mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(mapped);
    }
}