package com.gponder.structure;

import java.util.*;

/**
 * @Author gponder
 * @Email gponder.g@gmail.com
 * @create 2020/3/23 16:36
 *
 * @see java.util.HashMap
 *
 */
public class MapTest {
    /**
     * 区别:
     * 1 null值
     * 2 线程安全 效率
     * 3 遍历
     *
     * 相同
     * hashtable也是map
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Hashtable<Object,Object> table = new Hashtable<>();
        HashMap<Object,Object> map = new HashMap<>();
        for (int i=0;i<10;i++){
            table.put(i,i);
            map.put(i,i);
        }
        Enumeration<Object> keys = table.keys();
        System.out.println("table key");
        while (keys.hasMoreElements()){
            System.out.println(keys.nextElement());
        }
        Enumeration<Object> elements = table.elements();
        System.out.println("table value");
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
        table.keySet();table.values();
        Set<Object> keySet = map.keySet();
        Iterator<Object> it = keySet.iterator();
        System.out.println("map key");
        while (it.hasNext()){
            System.out.println(it.next());
        }
        Collection<Object> mapValues = map.values();
        Iterator<Object> vIt = mapValues.iterator();
        System.out.println("map value");
        while (vIt.hasNext()){
            System.out.println(vIt.next());
        }
    }

}
