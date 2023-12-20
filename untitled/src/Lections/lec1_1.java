package Lections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lec1_1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("привет" ," мир", "!", "я", "родился", "!");
//        list = list.stream().filter(str -> str.length()>4).collect(Collectors.toList());
//        for(String item: list){
//            System.out.println(item);
//        }


//        list.stream().filter(str -> str.length()>4).forEach(System.out::println);

        list.stream().filter(str -> str.length()>4).filter(s -> s.contains("о")). forEach(System.out::println);


        Arrays.asList(1,2,3,4,5,6,7).stream().map(chislo ->chislo * chislo).forEach(System.out::println);

        Arrays.asList(1,4,3,47,532,6,27).stream().sorted().forEach(System.out::println);
        System.out.println(  Arrays.asList(1,4,3,47,532,6,27).stream().findFirst().get());
    }
}
