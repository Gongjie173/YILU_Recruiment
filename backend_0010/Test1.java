package backend_0010;

public class Test1 {
    static void main() {
        //构造长方形和圆
        //接口引用指向实现类对象
        Perarea rec = new Rectangle(10, 5);
        Perarea cir = new Circle(5);
        //调用实现类实现的方法:
        double recArea = rec.get_area();
        double recPerimeter = rec.get_perimeter();
        double cirArea = cir.get_area();
        double cirPerimeter = cir.get_perimeter();
        //输出结果:
        System.out.println("长方形的面积为: " + recArea + ", 周长为: " + recPerimeter);
        System.out.println("圆的面积为: " + cirArea + ", 周长为: " + cirPerimeter);
    }

}
