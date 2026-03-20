package _0011_2_A;

//共享数据:玩家hp
public class Player {
    // 玩家初始 hp 值为 100
    private int hp = 100;

    //构造方法
    public Player() {
    }

    //get方法
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}
