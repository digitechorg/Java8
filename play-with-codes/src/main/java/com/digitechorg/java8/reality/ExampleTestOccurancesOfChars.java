package com.digitechorg.java8.reality;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleTestOccurancesOfChars {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple hi hai");

        Map<Character,Long> charFrequency= words.stream()
                .flatMap(a->a.chars().mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

      //  System.out.println(charFrequency);

        int [] array = {1,5,9,12,9,1,5,1,3};

     Map<Integer,Long> arrays=  Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(arrays);


    }
}
