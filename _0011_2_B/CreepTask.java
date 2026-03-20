package _0011_2_B;

public class CreepTask implements Runnable {
    //任务名字
    String name;
    //伤害:20
    public final int hurt = 20;
    //攻击任务需要知道攻击目标
    Player target;

    //构造方法
    public CreepTask(String name, Player target) {
        this.name = name;
        this.target = target;
    }
    @Override
    public void run() {
        target.attacked(this);
    }
}