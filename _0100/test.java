package _0100;

public class test {
    static void main() {
        //创建两个Singleton对象,看是否实现了单例
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // == 通过比较对象的内存地址来判断引用是否指向同一个对象
        // 不能用equals:equals() 比较的是对象的内容（值是否相等）
        System.out.println(instance1 == instance2);
    }
}
