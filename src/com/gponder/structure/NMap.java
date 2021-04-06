package com.gponder.structure;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/11/19 16:53
 */
public class NMap<K,V> implements Map<K,V> {

    static final int DEFAULT_INIT_CAP = 1<<4;
    static final int MAX_CAP = 1<<30;
    static final float LOAD_FAC = 0.75f;

    static final int TREEIFY = 8;
    static final int UNTREEIFY = 6;
    static final int MIN_TREEIFY_CAP=64;

    public NMap() {

    }
    /**
     *
     * @param cap
     */
    public NMap(int cap,float loadFactor) {

    }

    /**
     * 取值范围0 1<<30
     * @param cap
     * @return
     */
    public int tableSizeFor(int cap){
        cap = cap-1;
        cap = cap | (cap >>1);
        cap = cap | (cap >>2);
        cap = cap | (cap >>4);
        cap = cap | (cap >>8);
        cap = cap | (cap >>16);
        return cap+1;
    }


    public static void main(String[] args) {
        NMap<String, Object> nMap = new NMap<String, Object>();

        System.out.println(nMap.tableSizeFor(10));
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
}
