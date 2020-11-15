package linkList;

/**
 * @Description : 链表测试类
 * @Author : WDB
 * @Date: 2020-09-28 18:06
 */
public class LinkListTest {
    public static void main(String[] args) {
        SingleLinkList<String> stringSingleLinkList = new SingleLinkList<>();
        stringSingleLinkList.add("hello");
        stringSingleLinkList.add("world");
        stringSingleLinkList.add("hello");
        stringSingleLinkList.add("java");
        System.out.println(stringSingleLinkList);

        stringSingleLinkList.remove(3);

        stringSingleLinkList.add("php");

        stringSingleLinkList.insert(0,"think");
        stringSingleLinkList.insert(1,"in");
        stringSingleLinkList.insert(2,"java");

        stringSingleLinkList.insert(6,"python");

        System.out.println(stringSingleLinkList);

        stringSingleLinkList.inverse();

        System.out.println(stringSingleLinkList);
        SingleLinkList<String> stringSingleLinkList1 = new SingleLinkList<>();
        stringSingleLinkList1.add("1");
        stringSingleLinkList1.add("2");
        boolean flag = stringSingleLinkList1.palindromic();
        System.out.println(flag);
    }
}
