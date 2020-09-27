/**
 * @Description : volatile验证
 * @Author : WDB
 * @Date: 2020-09-27 14:33
 */
public class TestVolatile implements Runnable{
    private volatile int count = 10000;
    @Override
    public void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + "CurrentCount:" + count);
    }

    public static void main(String[] args) {
        TestVolatile t = new TestVolatile();
        for(int i=0;i<10000;i++){
            new Thread(t,"thread"+i).start();
        }
    }
}
