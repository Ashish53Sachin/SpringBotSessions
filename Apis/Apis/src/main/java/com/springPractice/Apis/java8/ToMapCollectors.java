package com.springPractice.Apis.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMapCollectors {

    public static void main(String args[]){

        /*
        1st QuestionAnswer
         */
        List<String> names= Arrays.asList("Ram","Shyam","Ashish","Bala");

        Map<String,Integer> hashMap=names.stream().collect(Collectors.toMap(x->x,String::length));

        hashMap.forEach((k, v) -> System.out.println(k + "-" + v));

        /*
        2nd QuestionAnswer
         */

        Map<String,char[]> hashMapChar=names.stream().collect(Collectors.toMap(x->x,String::toCharArray));

        hashMapChar.forEach((k, v) -> System.out.println(k + "-" + Arrays.toString(v)));
        
        /*
        count occurrence of a word in list String
         */

        List<String> allMultipleNames= Arrays.asList("Ram","Shyam","Ashish","Bala","ShivParvati"
        , "ShivParvati", "Ram","Shyam","Ashish");

        Map<String, Long> counts = allMultipleNames.stream()
                .collect(Collectors.groupingBy(
                        x->x,
                        Collectors.counting()
                ));

        counts.forEach((k, v) -> System.out.println(k + "-" + v));
        /*
        is groupingBy return type is Map?

        Yes, the return type of Collectors.groupingBy() is always a Map<K, V>.
         */
        // Return Type: Map<String, List<String>>
        Map<String, List<String>> map = allMultipleNames.stream()
                .collect(Collectors.groupingBy(s -> s));

        map.forEach((k, v) -> System.out.println(k + "-" + v));
        /*
        ShivParvati-[ShivParvati, ShivParvati]
        Shyam-[Shyam, Shyam]
        Ashish-[Ashish, Ashish]
        Bala-[Bala]
        Ram-[Ram, Ram]
         */
        // Corrected type for counting
        Map<String, Long> countsMap = allMultipleNames.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        countsMap.forEach((k, v) -> System.out.println(k + "-" + v));






    }

}
