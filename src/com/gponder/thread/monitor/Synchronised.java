package com.gponder.thread.monitor;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/11/18 16:35
 * 通过monitor实现 javap -v查看字节码
 * 开始指令monitorenter
 * 结束指令monitorexit
 *
 *
 * 对象:
 *  对象头、实例数据和对齐填充
 * 对象头(Word长度取决于jvm 32位虚拟机word为32位)
 *  1 Mark Word
 *  2 Klass Word (指向类的指针)
 *  3 Array Length (数组对象才有)
 *
 *
 * 偏向锁:
 *  解决的问题:在大多数情况下，锁不仅不存在多线程竞争，而且总是由同一线程多次获得 (减少CAS操作耗时)
 *  获取锁时 无锁改变偏向锁标志位,有锁查看线程ID,线程不同时进行cas
 * 自旋锁:
 *  开启方式: -XX:+UseSpinning
 *  解决问题:对象锁的锁状态只会持续很短一段时间,减少频繁地阻塞和唤醒线程   (降低线程切换的成本)
 *  该线程等待一段时间,自旋一定次数,自适应的自旋锁自旋次数由前一次在同一个锁上的自旋时间及锁的拥有者的状态
 * 轻量级锁:
 *  解决问题:所竞争较小时降低锁性能消耗  减少无实际竞争情况下，使用重量级锁产生的性能消耗
 *  Mark Word中的部分字节CAS更新指向线程栈中的Lock Record，如果更新成功，则轻量级锁获取成功，记录锁状态为轻量级锁；否则，说明已经有线程获得了轻量级锁，目前发生了锁竞争（不适合继续使用轻量级锁），接下来膨胀为重量级锁。
 * 重量级锁(悲观锁,阻塞同步):
 *  检测到重量级锁后挂起线程,不会消耗cpu但是唤醒比较耗时阻塞或者唤醒一个线程时，都需要操作系统来帮忙，这就需要从用户态转换到内核态，而转换状态是需要消耗很多时间的，有可能比用户执行代码的时间还要长
 *
 *
 *
 *
 */
public class Synchronised {

}
