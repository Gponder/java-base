package com.gponder.structure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleMap<K,V>  implements Map<K,V> {

    public static void main(String[] args) {
        HashMap<Object,Object> map = new HashMap<Object, Object>();
        for (int i=0;i<10;i++){
            map.put(i,i);
        }
        for (int i=0;i<10;i++){
            map.put(1,1);
        }
        SimpleMap<Object, Object> sMap = new SimpleMap<Object, Object>();
        sMap.put(1,1);
        sMap.put(2,2);
        System.out.println(sMap.get(1));
        System.out.println(sMap.get(2));
    }

    static final int max_capacity=1<<30;
    static final int default_init_capacity=1<<4;
    static final float default_load_factor=0.75f;
    static final int treeify_threshold=8;
    static final int untreeify_threshold=6;

    float loadFactor;
    int threshold;
    int size;

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

    private int hash(Object key) {
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
        Node<K, V> node = getNode(hash(key), key);
        return node==null?null:node.getValue();
    }

    private Node<K, V> getNode(int hash, Object key) {
        int len = table.length;
        Node<K,V> first;
        if (table!=null && len!=0 && (first=table[hash & (len-1)]) !=null){
            if (first.hash==hash && (first.getKey()==key || first.getKey().equals(key))){
                return first;
            }
            if (first.next!=null){
                if (first instanceof TreeNode){
                    return ((TreeNode)first).getTreeNode(hash,key);
                }else{
                    Node<K,V> node = first.next;
                    do {
                        if (node.hash==hash && (node.getKey()==key || node.getKey().equals(key))){
                            return node;
                        }
                    }while ((node=node.next)!=null);
                }
            }
        }
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
        int index,cap = table.length;
        Node<K, V> node = table[index=hash&(cap-1)];
        if (node==null){
            table[index] = new Node<K,V>(hash,key,value,null);
            ++size;
            if (size>=threshold){
                resize();
            }
        }else if (node instanceof TreeNode){
            node = node.putTreeValue();
        }else{
            for (int nodeCount=0;;nodeCount++){
                if (node.next==null){
                    node.next = new Node<K,V>(hash,key,value,null);
                    if (nodeCount>=treeify_threshold){
                        treeifyNode(table,hash);
                    }
                    node = node.next;
                    break;
                }
                if (node.hash==hash && (node.getKey().equals(key))||node.getKey()==key){
                    node.setValue(value);
                    node = node.next;
                    break;
                }
                node = node.next;
            }
        }
        if (node!=null){
            V oldValue = node.getValue();
            node.setValue(value);
            return oldValue;
        }
        return null;
    }

    private void treeifyNode(Node<K, V>[] table, int hash) {

    }

    private Node<K, V>[] resize() {
        int oldCapacity = table==null?0:table.length;
        int oldThreshold = threshold;
        int newCapacity,newThreshold=0;
        if(oldCapacity>0){
            if (oldCapacity>=max_capacity){
                threshold = Integer.MAX_VALUE;
                return table;
            }
            newCapacity = oldCapacity <<1;
            if (newCapacity<max_capacity && oldCapacity>=default_init_capacity){
                newThreshold=oldThreshold<<1;
            }
        }else if (oldThreshold>0){
            //oldCapacity 等于0 没初始化 oldThreshold 大于0 构造方法 tableSizeFor 赋值
            newCapacity = oldThreshold;
        }else{
            //构造时没有传入容量
            newCapacity = default_init_capacity;
            newThreshold = (int) (default_init_capacity * loadFactor);
        }
        threshold = newThreshold;
        Node<K,V>[] newTable = new Node[newCapacity];
        if (table!=null){
            for (int i=0;i<table.length;i++){
                Node<K, V> node = table[i];
                if (node!=null){
                    table[i]=null;

                    if (node.next==null){
                        newTable[node.hash & (newCapacity-1)]=node;
                    }else if (node instanceof TreeNode){
                        ((TreeNode<K,V>)node).split(this,newTable,i,oldCapacity);
                    }else{
                        Node<K,V> loNode = null,liTail=null;
                        Node<K,V> hiNode = null,hiTail=null;
                        do{
                            if ((node.hash & oldCapacity) ==0){
                                if (liTail==null){
                                    loNode = node;
                                }else{
                                    liTail.next=node;
                                }
                                liTail = node;
                            }else{
                                if (hiTail==null){
                                    hiNode = node;
                                }else {
                                    hiTail.next = node;
                                }
                                hiTail = node;
                            }
                        }while ((node = node.next)!=null);
                        if (loNode!=null){
                            liTail.next = null;
                            newTable[loNode.hash&(newCapacity-1)] = loNode;
                        }
                        if (hiNode!=null){
                            hiTail.next = null;
                            newTable[hiNode.hash&(newCapacity-1)] = hiNode;
                        }
                    }
                }
            }
        }
        table = newTable;
        return table;
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
        final int hash;
        final K k;
        V v;
        Node next;

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

        public Node<K, V> putTreeValue() {
            return null;
        }
    }

    class TreeNode<K,V> extends Node<K,V>{
        TreeNode<K,V> parent;
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;
        boolean red;

        public TreeNode(int hash, K k, V v, Node next) {
            super(hash, k, v, next);
        }

        public void split(SimpleMap<K, V> kvSimpleMap, Node<K, V>[] newTable, int i, int oldCapacity) {
            TreeNode<K,V> node = this;
            TreeNode<K,V> loHead = null,loTail = null;
            TreeNode<K,V> hiHead = null,hiTail = null;
            int lc = 0,hc = 0;
            do {
                if ((node.hash & oldCapacity) == 0){
                    if (loTail==null){
                        loHead=node;
                    }else {
                        loTail.next=node;
                    }
                    loTail = node;
                    lc++;
                }else {
                    if (hiTail==null){
                        hiHead=node;
                    }else {
                        hiTail.next = node;
                    }
                    hiTail = node;
                    hc++;
                }
            }while ((node = (TreeNode)node.next)!=null);
            if (loHead!=null){
                loTail.next=null;
                newTable[loHead.hash & newTable.length-1] = loHead;
                if (lc<=untreeify_threshold){
                    loHead.untreeify();
                }else{
                    loHead.treeify();
                }
            }
            if (hiHead!=null){
                hiTail.next=next;
                newTable[hiHead.hash & newTable.length-1] = hiHead;
                if (hc<=untreeify_threshold){
                    hiHead.untreeify();
                }else {
                    hiHead.treeify();
                }
            }
        }

        private void treeify() {

        }

        private void untreeify() {

        }

        public TreeNode<K, V> find() {
            return null;
        }

        public Node<K, V> getTreeNode(int hash, Object key) {
            return null;
        }
    }
}
