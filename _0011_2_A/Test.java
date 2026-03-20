package _0011_2_A;

public class Test {
    static void main() {
        Player player = new Player();
        //创建任务
        CreepTask task1 = new CreepTask("Creep-A", player);
        CreepTask task2 = new CreepTask("Creep-B", player);
        //创建两条线程
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
    }
}
