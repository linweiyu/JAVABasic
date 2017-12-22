package Basic.ThreadOperate;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncThread2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Work(1));
        Thread thread1 = new Thread(new Work(2));
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Over" + Work.getNumber());
    }
}

class Work implements Runnable {
    private static Integer number = 10;
    private static Lock lock = new ReentrantLock();
    private int name;

    public static Integer getNumber() {
        return number;
    }

    public Work(int name) {
        this.name = name;
    }
    // another way to synchronized
    public void run() {
            lock.lock();
            while (number > 0) {
                System.out.println(name + " : " + number);
                number--;
            }
            lock.unlock();
    }

//    public void run() {
//        synchronized (number) {
//            while (number > 0) {
//                System.out.println(name + " : " + number);
//                number--;
//            }
//        }
//    }

}