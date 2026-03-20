package _0011_3;

public class MyLinkedList<E> {
    //成员:
    private int size = 0;
    private Node<E> first = null;
    private Node<E> last = null;

    //内部类:Node
    private static class Node<E> {  // static:避免不必要的引用,private:隐藏实现细节
        //Node的成员变量:
        E item;
        Node<E> next;
        Node<E> prev;
        //Node的构造方法
        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    //构造函数
    public MyLinkedList() {
    }

    //1. 添加节点
    public boolean addList(Node<E> node) {
        if (first == null) {  // 如果链表为空
            first = node;     //添加的节点为第一个节点
        } else {
            last.next = node;
            node.prev = last;
        }
        last = node;          // 更新该节点为最后一个节点
        size++;
        return true;
    }
    //2. 删除尾节点
    public void removeList0() {
        if (first == null) {   // 如果链表为空
            return;
        }
        if (first == last) {   // 如果只有一个节点
            first = last = null;
            size--;
            return;
        }
        last = last.prev;
        last.next = null;
        size--;
    }
    //3. 根据节点值删除节点
    public void removelistByValue(E value) {            // 这里我改了题目的int value
        if (first == null) {
            return;
        }
        if (first.item.equals(value)) {
            //如果目标节点是第一个节点first
            first = first.next;  //first后移,后移后判断是否为空
            if (first != null) {
                first.prev = null;
            }
        } else if(last.item.equals(value)) {
            //如果目标节点是最后一个节点
            last = last.prev;
            last.next = null;
        } else {
            //遍历寻找节点
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(value)) {
                    x.prev.next = x.next;
                    x.next.prev = x.prev;
                    break;
                }
            }
        }
        size--;
    }
    //4. 找到值为 value 的结点，返回这个结点下标（下标从 0 开始计算）
    public int find(E value) {
        if (first == null) {
            return -1;
        }
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item.equals(value)) {
                return i;
            }
            i++;
        }
        return -1;  //如果执行到这里,说明没有找到
    }

}
