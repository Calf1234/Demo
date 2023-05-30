package com.calf1234.data.list;

public class LinkedList<T> {

    int size;
    Node<T> list;

//    增
    public void put(T data) {
        Node head = list;
        Node curNode = new Node(data, head);
        list = curNode;
        size++;
    }

    public void put(int index, T data) throws Exception {
        if (index == 0) {
            put(data);
            return;
        }

        checkPositionIndex(index);
        Node curNode = list;
        Node head = list;
        for (int i = 0; i < index; i++) {
            head = curNode;
            curNode = curNode.next;
        }
        Node node = new Node(data, curNode);
        head.next = node;
        size++;
    }

    private void checkPositionIndex(int index) throws Exception {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException(String.format("index: %d 非法，size: %d", index, size));
        }
    }

//    删
    public T remove() {
        if (list != null) {
            Node node = list;
            list = list.next;
            node.next = null;
            size--;
            return (T) node.data;
        }
        return null;
    }

    public T remove(int index) throws Exception {
        if (index == 0) {
            return remove();
        }

        checkPositionIndex(index);
        Node curNode = list;
        Node head = list;
        for (int i = 0; i < index; i++) {
            head = curNode;
            curNode = curNode.next;
        }
        head.next = curNode.next;
        curNode.next = null;
        size--;
        return (T) curNode.data;
    }

    public T removeLast() {
        if (list != null) {
            Node node = list;
            Node curNode = list;
            while (curNode.next != null) {
                node = curNode;
                curNode = curNode.next;
            }
            node.next = null;
            size--;
            return (T) curNode.data;
        }
        return null;
    }

//    改
    public void set(int index, T newData) throws Exception {
        checkPositionIndex(index);
        Node head = list;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        head.data = newData;
    }

//    查
    public T get() {
        Node node = list;
        if (node == null) {
            return null;
        } else {
            return (T) node.data;
        }
    }

    public T get(int index) throws Exception {
        checkPositionIndex(index);
        Node node = list;
        for (int i = 0; i < index; i++) {
            node  = node.next;
        }
        return (T) node.data;
    }

    @Override
    public String toString() {
        Node node = list;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
        return super.toString();
    }

    class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

//    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for(int i = 0; i < 5; i++) {
//            list.put(i);
//        }
//        list.toString();
//
//        try {
//            list.put(3,3);
//            list.toString();
//            list.put(0,8);
//            list.toString();
//            list.put(1,7);
//            list.toString();
//
//            list.remove();
//            list.toString();
//            list.remove(0);
//            list.toString();
//            list.remove(3);
//            list.toString();
//            list.removeLast();
//            list.toString();
//
//            list.set(2, 8);
//            list.toString();
//            list.set(0, 2);
//            list.toString();
//
//            System.out.println(list.get(0));
//            System.out.println(list.get(2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
