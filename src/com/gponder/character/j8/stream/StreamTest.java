package com.gponder.character.j8.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamTest {

    List<List<Map<String,String>>> datas;

    private static void accept(Map<String, String> stringStringMap) {

    }

    private StreamTest initData(){
        datas = new ArrayList<>();
        for (int i=0;i<3;i++){
            List<Map<String,String>> dataGroup= new ArrayList<>();
            for (int j=0;j<5;j++){
                Map<String,String> data = new HashMap<>();
                data.put("time",System.currentTimeMillis()+"");
                data.put("i",i+"");
                data.put("j",j+"");
                dataGroup.add(data);
            }
            datas.add(dataGroup);
        }
        return this;
    }

    private void map(){
        Object[] o = datas.stream().map(x -> {
            System.out.println(x);
            int[] a = {1, 2};
            return a;
        }).toArray();
        System.out.println(Arrays.toString(o));
    }

    private void flatMap(){
        datas.stream().flatMap(new Function<List<Map<String, String>>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<Map<String, String>> maps) {
                return maps.stream();
            }
        }).forEach(System.out::println);
    }


    public static void main(String[] args) {
//        new StreamTest().initData().map();
        new StreamTest().initData().flatMap();
    }
}
