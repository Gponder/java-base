package com.gponder.structure;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<?> whatsIt = getSomething();
        Object first = whatsIt.get(0);
        System.out.println(first);

        SomeObjet so = new SomeObjet();
        System.out.println(so.getType("a",1));
    }

    public static List<?> getSomething(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        return list;
    }

    public static List<? extends Number> getSon(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        return list;
    }

    public static List<? super Integer> getSuper(){
        List<Object> list = new ArrayList<>();
        list.add(1);
        return list;
    }

    static class SomeObjet<T>{
        public <V,K,M> V getType(V v,T t){
            System.out.println(t.getClass());
            return v;
        }

        public <V> Integer getType(V v){
            return v.toString().length();
        }
    }
}
