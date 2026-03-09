package backend_0010;

public class Test2 {
    static void main() {
        //创建一个左上角坐标为（10，10），长为20，宽为10的 PlainRect 对象
        PlainRect pr = new PlainRect(20, 10, 10, 10);
        //计算并打印输出矩形的面积和周长
        double prArea = pr.area();
        double prPerimeter = pr.perimeter();
        System.out.println("长方形面积为: " + prArea + ", 周长为: " + prPerimeter);
        //判断点(25.5，13)是否在矩形内，并打印输出相关信息。
        if (pr.isInside(25.5, 13)) {
            System.out.println("点(25.5, 13)在矩形内");
        } else {
            System.out.println("点(25.5, 13)不在矩形内");
        }
    }


}
