package _0011_2_A;

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

    //方法:攻击
    public void attack() {
        //攻击三次
        for (int i = 0; i < 3; i++) {
            if (target.getHp() == 0) {
                System.out.println(name + ": player is dead.");
            } else {
                int new_hp = target.getHp() - hurt;
                target.setHp(new_hp);
                System.out.println(name + " attack...");
                System.out.println(name + ": 当前player的hp值=" + target.getHp());
            }
        }
        System.out.println(name + ": end.");
    }

    @Override
    public void run() {
        //同步块
        synchronized (target) {  // 锁定贡献资源 - 共同攻击的target
            attack();
        }
    }
}