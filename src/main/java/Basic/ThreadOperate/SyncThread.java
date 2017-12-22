package Basic.ThreadOperate;

public class SyncThread {
    public static void main(String[] args){
        Account account = new Account(100);
        //SaveOperation operation = ;
        Thread work = new Thread(new SaveOperation("work", account));
        Thread work2 = new Thread(new SaveOperation("work2", account));
        work.start();
        work2.start();
    }
}

class SaveOperation implements Runnable{
    private String name;
    private Account account;
    public SaveOperation(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        for(int i = 0; i < 10; i++){
            account.saveMoney(10);
            System.out.println(name + " : " + account.getMoney());
        }
    }
}

class Account{
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void saveMoney(int addmoney){
        money += addmoney;
    }
}