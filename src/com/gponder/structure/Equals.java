package com.gponder.structure;

import java.util.HashMap;
import java.util.Set;

public class Equals {
    public static void main(String[] args) {
        HashMap<Man,Integer> map = new HashMap<>();
        for (int i=0;i<10;i++){
            map.put(new Man(i),i);
        }
        Set<Man> keys = map.keySet();
        for (Man key:keys){
            System.out.println(key.getAge());
        }
    }
}
