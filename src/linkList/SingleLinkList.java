package linkList;

/**
 * @Description : Java 单链表实现
 * @Author : WDB
 * @Date: 2020-09-27 19:32
 */
public class SingleLinkList<T> {
    private Node<T> header;
    private int size;
}

class Node<T> {
    private T data;
    private T next;

    public Node(T data, T next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getNext() {
        return next;
    }

    public void setNext(T next) {
        this.next = next;
    }
}