package geek.week01;

import java.math.BigInteger;

/**
 * @Description : 测试
 * @Author : WDB
 * @Date: 2020-10-20 23:56
 */
public class Hello {
    public static void main(String[] args) {
        BigInteger no = BigInteger.valueOf(701).shiftLeft(16).add(BigInteger.ZERO).shiftLeft(8).add(BigInteger.ZERO);
        System.out.println(no);
    }
}
