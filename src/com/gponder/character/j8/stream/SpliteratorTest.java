package com.gponder.character.j8.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorTest {

    List<String> strings;

    public SpliteratorTest() {
        strings= new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");
        strings.add("h");
        strings.add("i");
        strings.add("j");
    }

    public static void main(String[] args) {
        SpliteratorTest spliteratorTest = new SpliteratorTest();
        spliteratorTest.change();
    }

    private void change() {
        Spliterator<String> spliterator = strings.spliterator();
        Spliterator<String> s1 = spliterator.trySplit();
        Spliterator<String> s2 = spliterator.trySplit();
        System.out.println("s1");
        forEach(s1);
        System.out.println("s2");
        forEach(s2);
        System.out.println("sp");
        forEach(spliterator);
    }

    private void forEach(Spliterator<?> spliterator){
        boolean b;
        do {
            b = spliterator.tryAdvance(System.out::println);
        }while (b);
    }
}
