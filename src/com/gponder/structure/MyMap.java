package com.gponder.structure;


import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K,V>  implements Map<K,V> {

    Set<K> keys;
    Set<Map.Entry<K,V>> entries;

    public static void main(String[] args) {
        MyMap<Man, Integer> map = new MyMap<>();
        for (int i=0;i<1;i++){
            map.put(new Man(i),i);
        }
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        System.out.println(key.getClass());
        System.out.println(value.getClass());
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
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
