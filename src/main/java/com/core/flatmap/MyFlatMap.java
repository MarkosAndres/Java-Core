package com.core.flatmap;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFlatMap {
    public static void main(String[] args) {

        Optional<Optional<String>> myStrings = Optional.of(Optional.of("STRING"));
        Optional<Optional<String>> myStrings2 = Optional.of("string").map(s -> Optional.of("STRING"));

        Optional<String> myStrings3 = Optional.of("String");
        Optional<String> myStrings4 = Optional.of("string").flatMap(s -> Optional.of("String"));

        assertEquals(myStrings3, myStrings4);



        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        List<String> a = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(a);

    }
}
