package com.wei.study.jvm.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4");

        Stream<List<Integer>> listStream = list.stream().map(str -> Integer.parseInt(str)).map(num -> {
            List<Integer> a = new ArrayList<>();
            a.add(num);
            return a;
        });

        Optional<List<Integer>> reduce = listStream.reduce((a, b) -> {
            a.addAll(b);
            return a;
        });

        System.out.println(reduce.get());
    }
}
