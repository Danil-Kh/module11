package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {

    public static void main(String[] args) {

        String[] testData = new String[] {"anna", "iavn", "danil", "igory", "yra"};
        String[] testDataInt = new String[] {"1, 2, 0", "4, 5"};
        String[] testDataToZip = new String[] {"1","1","1", "1", "1", "1"};
        String[] testDataToZip2 = new String[] {"2","2","2","2","2"};


        System.out.println("countName(testData) = " + (countName(testData)));
        System.out.println("sorterString(testData) = " + sorterString(testData));
        sortedInt(testDataToZip);
        // random(25214903917L, 11,  Math.pow(2, 48)).forEach(System.out :: println);
        zip(stream(testDataToZip), stream(testDataToZip2)).forEach(System.out ::println);


    }
    public static String countName(String[] array){

        String[] result = IntStream.range(0, array.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + array[i])
                .toArray(String[] :: new);

        return stream(result).collect(Collectors.joining(", "));
    }
    public static List<String> sorterString(String[] name){
        List<String> list = List.of(name);
       List<String> result = list.stream()
                .sorted(Comparator.reverseOrder())
               .map(String :: toUpperCase)
                .collect(Collectors.toList());
        return result;
    }
    public static void sortedInt(String[] name){
        List<String> list = List.of(name);
        List<String> listExtracted = list.stream()
                .map(x -> x.split(","))
                .flatMap(Arrays::stream)
                .map(String::trim)
                .sorted()
                .toList();
        System.out.println(listExtracted.stream().collect(Collectors.joining(", ")));
    }
    public static Stream<Long> random(Long a, int c, double m){
        return Stream.iterate(25L, n -> (long) ((a * n + c) % m));
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> list1 = first.toList();
        List<T> list2 = second.toList();

        Iterator<T> iterator = list1.iterator();
        Iterator<T> iterator1 = list2.iterator();
            String[] arr = IntStream.range(0, Math.min(list1.size(), list2.size()))
                    .mapToObj(i -> iterator.next() + ", " + iterator1.next())
                    .toArray(String[]::new);
        return (Stream<T>) stream(arr);
    }


}
