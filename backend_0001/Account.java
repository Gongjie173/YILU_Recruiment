package backend_0001;

import java.util.Scanner;

//类:银行账户系统
public class Account {
    //成员变量:账户号码, 余额
    private String accountID;
    private int balance;
    //构造方法:
    public Account() {
    }
    public Account(String accountID, int balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    //方法:取钱(抛出异常)
    public void withdraw (int withdrawamount) throws InsufficientBalanceException{
        //判断余额是否充足
        if (balance - withdrawamount < 0) {
            throw new InsufficientBalanceException("账户 " + accountID + " 余额不足, 余额: " + balance + "元, 而你尝试提取的金额为: " + withdrawamount + "元");
        }
        //充足则正常取出
        balance -= withdrawamount;
        System.out.println("顺利取出.当前余额: " + balance + "元~");

    }
    //方法:main
    public static void main (String[] args) {
        //创建账户实例:
        Account account = new Account("0001", 1000);
        //取钱(处理异常)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要提取的金额: ");
        int withdrawAccount = sc.nextInt();
        try {
            account.withdraw(withdrawAccount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }
}
