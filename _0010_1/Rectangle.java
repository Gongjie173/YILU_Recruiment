package _0010_1;

public class Rectangle implements Perarea {
    //私有化成员变量
    private double side1, side2;
    //构造方法
    public Rectangle() {
    }
    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
    //get&&set
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }
    //重写接口的方法:
    @Override
    public double get_area() {
        return side1 * side2;
    }

    @Override
    public double get_perimeter() {
        return 2 * (side1 + side2);
    }
}
