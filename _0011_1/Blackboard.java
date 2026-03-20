package _0011_1;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Blackboard {
    public Blackboard() {
    }
    /*共享资源, 作用:控制消费者和生产者的执行*/

    //总够只能布置20份作业
    public static int count = 20;
    //黑板上存放的布置了等待同学完成的作业  因为共享,所以static
    public static ArrayList<Homework> todoHomework = new ArrayList<>();
    //锁对象
    //public static Object lock = new Object();

    //换一种加锁方式
    public static Lock lock = new ReentrantLock();  // Lock 是接口,ReentrantLock是其实现类
    public static Condition condition = lock.newCondition(); // 条件变量 - 用于等待和通知(代替wait/notify)
}
