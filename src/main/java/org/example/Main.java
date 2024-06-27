package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {

    public static void main(String[] args) {

    }
    public static String[] countName(String[] array){

        String[] result = IntStream.range(0, array.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + array[i])
                .toArray(String[]::new);

        return result;
    }
    public static List<String> sorterString(String[] name){
        List<String> list = List.of(name);
       List<String> result = list.stream()
                .sorted(Comparator.reverseOrder())
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
        System.out.println(listExtracted);
    }
    public static Stream<Long> random(Long a, int c, Long m){
        return Stream.iterate(25L, n -> (a * n + c) % m);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        Iterator<String> iterator = (Iterator<String>) first.iterator();
        Iterator<String> iterator1 = (Iterator<String>) second.iterator();
        ArrayList<String> arrayList = new ArrayList<>();
        while (iterator1.hasNext() && iterator.hasNext()){
            arrayList.add(iterator.next() + " " + iterator1.next());
        }
        return (Stream<T>) arrayList.stream();
    }

}
