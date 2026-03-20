package _0011_1;

public class Test {
    static void main() {
        //构建生产者的实现类(老师)的对象
        Teacher t = new Teacher();
        t.setName("老师");
        //构建消费者的实现类(学生)的对象
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setName("张三同学");
        s2.setName("李四同学");
        s3.setName("王五同学");
        //启动线程
        t.start();
        s1.start();
        s2.start();
        s3.start();
    }

}
