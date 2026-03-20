package _0011_1;


//消费者的实现类
public class Student extends Thread implements Consumer{
    @Override
    public void doHomework() {
        Homework hw = Blackboard.todoHomework.removeFirst();
        System.out.println("🧑‍🎓" + getName() + "完成了" + hw.homeworkInfo() + ", 黑板上还有" + Blackboard.todoHomework.size() + "份作业需要做");
    }
    public void run() {
        while (true) {
            //1️⃣synchronized (Blackboard.lock) {;
            Blackboard.lock.lock();
            try {
                // 检查是否应该结束：没有待做作业，且老师不会再布置了
                if (Blackboard.count == 0 && Blackboard.todoHomework.isEmpty()) {
                    System.out.println("🧑‍🎓" + getName() + ":终于写完了!!");
                    break;
                }
                while (Blackboard.count != 0 && Blackboard.todoHomework.isEmpty()) {
                    //如果黑板上没有作业,而且老师作业还没有布置完,则等待
                    System.out.println("🧑‍🎓" + getName() + "拿到了线程,但是没有作业,等待");
                    try {
                        //1️⃣Blackboard.lock.wait();
                        Blackboard.condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // !!!唤醒后重新验证条件
                if (Blackboard.count == 0 && Blackboard.todoHomework.isEmpty()) {
                    System.out.println("🧑‍🎓" + getName() + ":终于写完了!!");
                    break;
                }
                //有作业
                doHomework();
                //写了作业之后唤醒所有线程
                //1️⃣Blackboard.lock.notifyAll();
                Blackboard.condition.signal();

            } finally {
                Blackboard.lock.unlock();  // 手动释放锁需要try - finally ,放在 finally{}里面,确保锁被释放
            }
            //1️⃣}
            //写完一份作业后休息一下
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
