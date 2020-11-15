package thread;

import java.math.BigDecimal;
import java.util.TimeZone;
import java.util.concurrent.*;

/**
 * @Description : 线程池测试
 * @Author : WDB
 * @Date: 2020-10-28 17:35
 */
public class TreadPoolTest {

    public static void main(String[] args) {
        double j = 1 - (double) 1 / 4;
        BigDecimal bg = new BigDecimal(j);
        j = bg.setScale(4, 4).doubleValue();
        System.out.println(j);
        //MathUtil.formatDoubleInDeg(1 - (double) this.getSuccessCount() / this.getTotalCount(), 4)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,1,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(10));
        ServiceTask task = new ServiceTask();
        executor.submit(task);
        executor.execute(task);
    }
}
