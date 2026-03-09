package backend_0010;

public class Rect {
    //私有化成员变量:矩形的宽 width；矩形的高 height
    private double width;
    private double height;
    //两个构造方法：一个带有两个参数，用于 width 和 height 属性初始化；一个不带参数，将矩形初始化为宽和高都为10。
    public Rect() {
        this.width = 10;
        this.height = 10;
    }
    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }
    //get&&set
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    //两个实例方法：一个求矩形面积 area()，另一个求矩形周长 perimeter()
    public double area () {
        return width * height;
    }
    public double perimeter () {
        return 2.0 * (width + height);
    }
}
