package thread;

/**
 * @Description : 业务线程模拟
 * @Author : WDB
 * @Date: 2020-10-31 20:58
 */
public class ServiceTask implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+":执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
