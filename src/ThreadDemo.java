public class ThreadDemo {
    static Thread t1 = null, t2=null;
    public volatile static Object obj = new Object();
    public static boolean order = false;
    public static void main(String[] args) {

        t1 = new Thread(()->{
            for (char s ='A';s <= 'Z';s++) {
                synchronized (obj) {
                    try {
                        obj.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    order = true;
                    System.out.println(s);
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        t2 = new Thread(()->{
            for (int i=1;i <= 26;i++) {
                synchronized (obj) {
                    if(!order){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        System.out.println(i);
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        t1.start();
        t2.start();
    }
}