package Basic.ThreadOperate;

public class ThreadApplication {
    public static void main(String[] args){
        Thread work = new WorkExtendThread("work1");
        Thread work2 = new Thread(new WorkImplementsRunnable("work2"));
        Thread work3 = new Thread(new Runnable() {
            public void run() {
                try{
                    for(int i = 0; i <= 10; i++){
                        System.out.println("work3 : " + i);
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        work.start();
        work2.start();
        work3.start();
    }
}

class WorkImplementsRunnable implements Runnable{
    private String name;

    public WorkImplementsRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for(int i = 0; i <= 10; i++){
                System.out.println(name + " : " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class WorkExtendThread extends Thread{

    public WorkExtendThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        try{
            for(int i = 0; i <= 10; i++){
                System.out.println(this.getName() + " : " + i);
                sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
