package _0011_1;

import java.util.Random;

public class Homework {
    //作业的三个属性: 学科, 页数, 难度
    //不是类的对象共享同一个学科,页数,难度,所以不用static
    private String subject;
    private int pages;
    private char difficult;

    private static final String[] subjectArr = {"语文", "数学", "英语"}; // "语文"数学"英语"
    private static final int[] pagesArr = {1, 2, 3, 4, 5}; // 每项作业只能在1-5页之间的一个数
    private static final char[] difficultArr = {'A', 'B', 'C'}; // 有A，B， C三种难度,递减
    // 构造方法
    public Homework () {
    }
    public Homework(String subject, int pages, char difficult) {
        this.subject = subject;
        this.pages = pages;
        this.difficult = difficult;
    }
    //静态方法,随机生成一份作业  因为创建一个新的Homework对象时,我不需要一个Homework实例
    public static Homework createHomework () {
        Homework hw = new Homework();
        Random r = new Random();
        hw.subject = subjectArr[r.nextInt(subjectArr.length)];
        hw.difficult = difficultArr[r.nextInt(difficultArr.length)];
        hw.pages = pagesArr[r.nextInt(pagesArr.length)];
        return hw;
    }
    //用于作业信息打印
    public String homeworkInfo () {
        return "一份难度为" + difficult + "的" + pages + "页" + subject + "科作业";
    }
}
