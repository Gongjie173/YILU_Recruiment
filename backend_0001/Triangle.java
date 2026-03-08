package backend_0001;

public class Triangle {
    //属性:三个边长
    private double side1, side2, side3;
    //构造方法:
    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    //Getter和Setter
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

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    //方法: 判断是否是三角形
    public boolean isTriangle () {
        return side1 > 0 && side2 > 0 && side3 > 0 &&
               side1 + side2 > side3 &&
               side1 + side3 > side2 &&
               side2 + side3 > side1;
    }

    //方法: 求面积(抛出异常)
    public double area () throws NotTriangle {
        //先判断三角形是否成立
        if (!isTriangle()) {
            throw new NotTriangle("三角形无法成立!");  // 如果不成立，则抛出自定义的 NotTriangle 异常类的实例
        }
        // 海伦公式求面积
        double p = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    //方法:main
    public static void main(String[] args) {
        //创建三角形实例
        Triangle tri1 = new Triangle(3.0, 4.0, 5.0);
        Triangle tri2 = new Triangle(1.0, 1.0, 2.0);
        //计算面积(需要处理异常)
        try {
            double area1 = tri1.area();
            System.out.println("三边为:" + tri1.getSide1() + ", " + tri1.getSide2() + ", " + tri1.getSide3() + " 的三角形面积为: " + area1);
        } catch (NotTriangle e) {
            System.out.println("三边为:" + tri1.getSide1() + ", " + tri1.getSide2() + ", " + tri1.getSide3() + " 的三角形面积无法计算, 原因: " + e.getMessage());
        }
        try {
            double area2 = tri2.area();
            System.out.println("三边为:" + tri2.getSide1() + ", " + tri2.getSide2() + ", " + tri2.getSide3() + " 的三角形面积为: " + area2);
        } catch (NotTriangle e) {
            System.out.println("三边为:" + tri2.getSide1() + ", " + tri2.getSide2() + ", " + tri2.getSide3() + " 的三角形面积无法计算, 原因: " + e.getMessage());
        }
    }
}
