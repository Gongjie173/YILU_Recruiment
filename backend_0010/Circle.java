package backend_0010;

public class Circle implements Perarea {
    //定义圆周率常量
    private static final double PI = 3.14;
    //私有化成员变量
    private double r;
    //构造方法
    public Circle() {
    }
    public Circle(double r) {
        this.r = r;
    }
    //get&&set
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }

    //重写接口的方法:
    @Override
    public double get_area() {
        return PI * r * r;
    }
    @Override
    public double get_perimeter() {
        return 2 * PI * r;
    }


}
