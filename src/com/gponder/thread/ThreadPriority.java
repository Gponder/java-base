package com.gponder.thread;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/27 11:11
 *
 * 线程的五种状态
 * 1. 新建(NEW)：new()
 * 2. 可运行(RUNNABLE)：start()
 * 3. 运行(RUNNING)：获取时间片（cpu timeslice）
 * 4. 阻塞(BLOCKED)：让出了时间片 （cpu timeslice）
 * 5. 死亡(DEAD)：run方法结束
 */
public class ThreadPriority {

    Thread thread = new Thread();

    /**
     * java 虚拟机总是会选择优先级较高的线程执行
     * 优先级相等的线程执行顺序是随机的无法干预
     * 只能控制到可运行状态 然后由虚拟机选择线程执行
     */
    public void priority() throws InterruptedException {
        thread.sleep(1000);thread.join();//线程先到阻塞态 条件符合是进入 可运行态
        Thread.yield();//线程从运行态转到可运行态
    }
}
