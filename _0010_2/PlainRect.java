package _0010_2;

//通过继承 Rect 类，编写一个具有确定位置的矩形类 PlainRect，其确定位置用矩形的左上角坐标来标识
public class PlainRect extends Rect {
    //新增两个属性（矩形左上角坐标 startX 和 startY）
    private double startX, startY;
    //get&&set
    public double getStartX() {
        return startX;
    }
    public void setStartX(double startX) {
        this.startX = startX;
    }
    public double getStartY() {
        return startY;
    }
    public void setStartY(double startY) {
        this.startY = startY;
    }
    //两个构造方法：一个带4个参数，用于对 startX、startY、width 和 height 属性初始化；一个不带参数，将矩形初始化为左上角坐标、长和宽都为0的矩形
    public PlainRect() {
        super(0, 0);
        this.startX = 0;
        this.startY = 0;
    }
    public PlainRect(double width, double height, double startX, double startY) {
        super(width, height);
        this.startX = startX;
        this.startY = startY;
    }
    //一个实例方法：判断某个点是否在矩形内部 isInside(double x, double y)。如在矩形内，返回 true；否则，返回 false。
    public boolean isInside (double x, double y) {
        return x > this.startX &&
               x < this.startX + this.getWidth() &&
               y > this.startY &&
               y < this.startY + this.getHeight();
    }

}