package com.calf1234.data.list;

/**
 * 内存淘汰算法：
 *  1、FIFO：first in first out
 *  2、LFU：least frequently used
 *  3、LRU：least recently used
 *      3.1、新数据插入到链表头部
 *      3.2、当缓存命中(即缓存数据被访问)，数据要移到表头
 *      3.3、当链表满的时候，将链表尾部的数据丢弃
 */
public class LruLinkedList<T> extends LinkedList<T> {

    static final int DEFAULT_CAPACITY = 6;
    int memery_size;

    public LruLinkedList() {
        memery_size = DEFAULT_CAPACITY;
    }

    public LruLinkedList(int memery_size) {
        this.memery_size = memery_size;
    }

    // 添加数据
    public void lruPut(T data) {
        if (size > memery_size) {
            removeLast();
        }
        put(data);
    }

    // 删除数据
    public T lruRemove(){
        removeLast();
        return null;
    }

    // 访问数据
    public T lruGet(int index) throws Exception {
        checkPositionIndex(index);
        Node node = list;
        Node pre = list;
        for (int i = 0; i < index; i++) {
            pre = node;
            node = node.next;
        }
        T resultData = (T) node.data;

        // 将访问的节点移到表头
        pre.next = node.next;
        Node head = list;
        node.next = head;
        list = node;
        return resultData;
    }

//    public static void main(String[] args) {
//        LruLinkedList<Integer> lruLinkedList = new LruLinkedList<>(5);
//        for(int i = 0; i <4; i++) {
//            lruLinkedList.lruPut(i);
//        }
//        lruLinkedList.toString();
//        try {
//            System.out.println(lruLinkedList.lruGet(3));
//            lruLinkedList.toString();
//            lruLinkedList.lruPut(20);
//            lruLinkedList.toString();
//
//            lruLinkedList.lruPut(18);
//            lruLinkedList.toString();
//
//            System.out.println(lruLinkedList.lruGet(0));
//            lruLinkedList.toString();
//
//            System.out.println(lruLinkedList.lruRemove());
//            lruLinkedList.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
