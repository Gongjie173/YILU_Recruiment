package _0011_1;

//生产者的实现类
public class Teacher extends Thread implements Producer{
    @Override
    public void assignHomework() {
        //随机生成一份作业并写在黑板上
        Homework hw = Homework.createHomework();
        Blackboard.todoHomework.add(hw);
        Blackboard.count--;
        System.out.print("\uD83D\uDC69\u200D\uD83C\uDFEB" + getName() + "布置了" + hw.homeworkInfo() + ", 还剩" + Blackboard.count + "份作业待布置.");
        System.out.println("----->此时黑板上还有" + Blackboard.todoHomework.size() + "份作业等待同学们做");
    }

    @Override
    public void run() {
        while (true) {
            //1️⃣synchronized (Blackboard.lock) {
            Blackboard.lock.lock();
            try {
                if (Blackboard.count == 0) {
                    System.out.println("\uD83D\uDC68\u200D\uD83C\uDFEB" + "老师：100 份作业已布置完毕！");
                    return;
                }
                while (Blackboard.todoHomework.size() > 5) {  // 在多线程等待 - 通知模式中，判断等待条件的地方都应该用 while，而不是 if
                    //如果黑板上的作业>5份
                    System.out.println("\uD83D\uDC69\u200D\uD83C\uDFEB" + "老师拿到了执行权,但是黑板上作业太多了,等待");
                    try {
                        //1️⃣Blackboard.lock.wait();
                        Blackboard.condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //布置作业
                assignHomework();
                //1️⃣Blackboard.lock.notifyAll();  // 释放所之前唤醒其他线程f
                Blackboard.condition.signalAll();
            } finally {
                Blackboard.lock.unlock();
            }
            //1️⃣}
            //布置完作业后休息一下
            /*try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
    }
}


