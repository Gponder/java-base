package com.gponder.structure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/21 23:44
 */
public class QueueTest {


    //queue 队列  put()和take()方法来实现生产者消费者模式
    public void blockingQueue() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
        blockingQueue.put("a");
        blockingQueue.take();
    }

    // deque 双向队列
    /**
     * 双向队列  线程安全
     */
    public void blockingDeque(){
        BlockingDeque<String> s = new LinkedBlockingDeque<>();
    }

    /**
     * 双向队列 基于链表实现的双端队列
     */
    public void linkList(){
        LinkedList<String> linkedList = new LinkedList<>();
    }

    /**
     * 双向队列 基于数组实现的双端队列
     */
    public void arrayDeque(){
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
    }


    public static void main(String[] args) {

    }


}
