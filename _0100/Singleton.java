package _0100;

/*懒汉式, 添加volatile关键字的双重检查锁方式*/
public class Singleton {
    //私有化构造方法
    private Singleton() {    //private私有不让外部创建对象
    }
    //声明Singleton类型的变量,static确保全局唯一
    private static volatile Singleton instance;  // volatile防止指令重排,防止多线程下出现空指针问题
    //对外提供公共的访问方式,要访问静态变量instance,所以是静态方法
    public static Singleton getInstance () {
        //第一次判断,如果instance的值不为null,则不需要抢占锁,直接返回已存在的instance(无锁快速路径)
        if (instance == null) {
            synchronized (Singleton.class) {
                //第二次还要判断instance是否为null,原因:线程A和线程B同时进入if判断,线程A创建了instance,线程B也创建了instance,那么就会产生多个instance实例
                if (instance == null) {
                    instance = new Singleton();  //创建对象并赋值给静态成员变量
                }
            }
        }
        return instance;
    }
}
