package com.gponder.structure;

import java.util.*;

public class MyMap<K,V>  implements Map {

    Set<K> keys;
    Set<Map.Entry<K,V>> entries;

    public static void main(String[] args) {
        MyMap<Object, Object> map = new MyMap<>();
        System.out.println(Integer.toHexString(map.hash("asdbasd")));
    }
    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean containsKey(Object key) {
        //getNode !=null
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return getNode(hash(key),key);
    }

    private Object getNode(int hash, Object key) {
        return null;
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public Object put(Object key, Object value) {

        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    class Node implements Map.Entry<K,V>{
        private int hash;
        private K k;
        private V v;
        private Node next;

        public Node(int hash, K k, V v, Node next) {
            this.hash = hash;
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            return this.v = value;
        }
    }
}
