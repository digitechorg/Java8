package com.digitechorg.java8.streamsonarray;

import java.util.Arrays;
import java.util.HashMap;

public class ExampleTestOccurancesofintinArray {
    // count occurances of each element in array
    public static void main(String[] args) {

     int [] array = {1,2,3,2,4,3,5};

        HashMap<Integer,Integer> hashMap = new HashMap<>();
      for(int i: array){
          if(hashMap.containsKey(i)){
              // if elements contains the key i , incrementing it's count by 1
              hashMap.put(i,hashMap.get(i)+1);
          }else{
              hashMap.put(i,1 );
          }

      }
        System.out.println("Input Array : "+ Arrays.toString(array));
        System.out.println(hashMap);
    }

}

