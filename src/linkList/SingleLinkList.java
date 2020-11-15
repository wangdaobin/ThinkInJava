package linkList;

import java.util.List;

/**
 * @Description : Java 单链表实现
 * @Author : WDB
 * @Date: 2020-09-27 19:32
 */
public class SingleLinkList<T>{
    /**
     * 链表头，第一个元素
     */
    private Node<T> header;
    /**
     * 链表尾，最后一个元素
     */
    private Node<T> tail;
    /**
     * 链表长度
     */
    private int size;

    public SingleLinkList() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 获取链表长度
     * @return 链表长度
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 判断是否为空
     * @return 空 true 非空 false
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 获取指定位置元素
     * @param i 元素位置
     * @return Node
     */
    public Node<T> getNode(int i){
        if(i< 0 || i >= size){
            throw new RuntimeException("下标越界");
        }
        Node<T> node = this.header;
        for(int j=0;j<i;j++){
            node = node.getNext();
        }
        return node;
    }

    /**
     * 链表尾添加元素
     * @param ele 要添加的元素
     */
    public void add(T ele) {
        Node<T> node = new Node<T>(ele,null);
        if(this.size == 0){
            this.header = node;
            this.tail = node;
        }
        tail.next = node;
        this.tail = node;
        this.size ++;
    }

    /**
     * 删除指定位置的元素
     * @param i 元素位置 0开始
     * @return 被删除的元素
     */
    public T remove(int i){
        if(i< 0 || i >= size){
            throw new RuntimeException("下标越界");
        }

        if(i == 0){
            this.header = header.next;
            this.size--;
            return header.data;
        }else{
            int count = 0;
            Node<T> preNode = this.getNode(i -1 );
            Node<T> delNode = preNode.next;
            preNode.next = delNode.next;
            delNode.next = null;
            //删除尾元素
            if(i == this.size -1){
                this.tail = preNode;
            }
            this.size--;
            return delNode.data;
        }

    }

    /**
     * 在指定位置插入数据
     * @param i 插入位置
     * @param data 数据
     */
    public void insert(int i,T data){
        if(i< 0 || i >= size){
            throw new RuntimeException("下标越界");
        }
        Node<T> node = new Node<>(data,null);
        if(i == 0){
            node.next = header;
            header = node;
        }else{
            int count = 0;
            Node<T> preNode = getNode(i -1);
            node.next = preNode.next;
            preNode.next = node;
        }
        size++;
    }

    /**
     * 翻转链表
     */
    public void inverse(){
        if(size == 0 || size == 1){
            return;
        }
        this.tail = header;
        Node<T> preNode = null;
        Node<T> currentNode = header;
        Node<T> nextNode = null;
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        this.header = preNode;
    }

    public boolean palindromic(){
        if(size == 0 || size == 1){
            return true;
        }
        Node<T> fast = header;
        Node<T> slow = header;
        Node<T> preNode = null;
        Node<T> next = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = preNode;
            preNode = slow;
            slow = next;
        }
        if(size % 2 != 0){
            slow = slow.next;
        }
        boolean flag = true;
        while(slow != null){
            T a = slow.data;
            T b = preNode.data;
            if(!a.equals(b)){
                flag = false;
                break;
            }
            slow = slow.next;
            preNode = preNode.next;
        }
        return flag;
    }

    @Override
    public String toString() {
        Node<T> header = this.header;
        String result = "";
        while(header != null) {
            result += header.data;
            result += "   ";
            header = header.next;
        }
        return result;
    }
}

class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}