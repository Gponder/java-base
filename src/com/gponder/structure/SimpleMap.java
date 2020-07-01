package com.gponder.structure;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleMap<K,V>  implements Map<K,V> {

    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<String, Object>(100,0.5f);
        map.put("a","a");
        int a = 0;
        System.out.println(a);
    }

    static final int max_capacity=1<<30;
    static final int default_init_capacity=1<<4;
    static final float default_load_factor=0.75f;

    float loadFactor;
    int threshold;

    private Node<K,V>[] table;

    public SimpleMap() {
        loadFactor = default_load_factor;
    }

    public SimpleMap(Integer cap) {
        this(default_load_factor,cap);
    }

    public SimpleMap(float loadFactor, int cap) {
        if (loadFactor<=0 || Float.isNaN(loadFactor)) throw new IllegalArgumentException("负载因子不合法"+loadFactor);
        this.loadFactor = loadFactor;
        if (cap<0)throw new IllegalArgumentException("容量不合法"+cap);
        if (cap>max_capacity)cap=max_capacity;
        this.threshold = tableSizeFor(cap);
    }

    private int tableSizeFor(Integer cap) {
        int n = cap-1;
        n |= n>>>1;
        n |= n>>>2;
        n |= n>>>4;
        n |= n>>>8;
        n |= n>>>16;
        return n<0 ? 1: n>=max_capacity?max_capacity:n+1;
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

    /**
     * 是否存在 存在则覆盖不存在则添加
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        return putValue(hash(key),key,value);
    }

    private V putValue(int hash, K key, V value) {
        if (table==null)resize();
        Node<K, V> node = table[hash];
        if (node==null)new Node<K,V>(hash,key,value,null);
        return null;
    }

    private void resize() {
        int oldCapacity = table==null?0:table.length;
        int oldThreshold = threshold;
        int newCapacity,newThreshold=0;

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


    class Node<K,V> implements Map.Entry<K,V>{
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
