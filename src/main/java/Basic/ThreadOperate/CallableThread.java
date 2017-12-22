package Basic.ThreadOperate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<Integer>{
    public static void main(String[] args){
        try{
            FutureTask<Integer> task = new FutureTask(new CallableThread());
            new Thread(task).start();
            // 使用get方法会阻塞线程
            System.out.println(task.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 0;
    }
}
