package _0001_2;

public class InsufficientBalanceException extends Exception{
    //带有错误信息参数的构造函数
    public InsufficientBalanceException (String message) {
        super(message);
    }
}
