package com.digitechorg.java8.streamsonarray;

import java.util.HashMap;

public class ExampleTestOccurrencesOfChars {

    public static void main(String[] args) {
        // name apple

        String str = "apple";
         char[] chars = str.toCharArray();
        HashMap<Character,Integer> charCountMap = new HashMap<>();
        for(char i:chars){
            if(charCountMap.containsKey(i)){
                charCountMap.put(i,charCountMap.get(i)+1);
            }else{
                charCountMap.put(i,1);
            }
        }
        System.out.println("passed string "+str);
        System.out.println(charCountMap);
    }
}
