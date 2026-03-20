package _0011_2_B;

//共享数据:玩家hp
public class Player {
    // 玩家初始 hp 值为 100
    private int hp = 100;

    //构造方法
    public Player() {
    }

    //get&&set
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    //同步方法:被攻击三次
    //!!!共享资源的持有者提供共享方法: 共享数据是hp,所以应该由player来提供同步方法安全操作hp.
    public synchronized void attacked (CreepTask ct) {
        //攻击三次
        for (int i = 0; i < 3; i++) {
            if (this.hp == 0) {
                System.out.println(ct.name + ": player is dead.");
            } else {
                int new_hp = this.getHp() - ct.hurt;
                this.setHp(new_hp);
                System.out.println(ct.name + " attack...");
                System.out.println(ct.name + ": 当前player的hp值=" + this.getHp());
            }
        }
        System.out.println(ct.name + ": end.");
    }
}
