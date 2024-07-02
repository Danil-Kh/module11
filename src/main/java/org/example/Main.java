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


      //  System.out.println("countName(testData) = " + (countName(testData)));
      //  System.out.println("sorterString(testData) = " + sorterString(testData));
      //  sortedInt(testDataToZip);
        // random(25214903917L, 11,  Math.pow(2, 48)).forEach(System.out :: println);

        var first = Stream.of(new User("A"), new User("B"), new User("C"));
        var second = Stream.of(new User("1"), new User("2"), new User("3"));
        zip(first, second).forEach(System.out ::println);


    }
    public static String countName(String[] array){

        return IntStream.range(0, array.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + array[i])
                .collect(Collectors.joining(", "));
    }
    public static List<String> sorterString(String[] name){
        List<String> list = List.of(name);
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .map(String :: toUpperCase)
                .collect(Collectors.toList());
    }
    public static void sortedInt(String[] name){
        List<String> list = List.of(name);
        System.out.println(list.stream()
                .map(x -> x.split(","))
                .flatMap(Arrays::stream)
                .map(String::trim)
                .sorted()
                .collect(Collectors.joining(", ")));
    }
    public static Stream<Long> random(Long a, int c, double m){
        return Stream.iterate(25L, n -> (long) ((a * n + c) % m));
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> list1 = first.toList();
        List<T> list2 = second.toList();
        Iterator<T> iterator = list1.iterator();
        Iterator<T> iterator1 = list2.iterator();

        return IntStream.range(0, Math.min(list1.size(), list2.size()))
                .mapToObj(i -> Stream.of(iterator.next(), iterator1.next()))
                .flatMap(s -> s);
    }
}
class User{
    String name;

    public User(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "name " + name;
    }
}
