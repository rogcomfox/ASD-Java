package com.nusantarian.livecoding;

class Node{
    String data;
    Node next, prev;
}

public class StackQueue{
    Node head, tail;
    private int size = 0;

    public void add(String data) {
       Node node = new Node();
        node.data = data;
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.next = null;
            tail = node;
        }
        size++;
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    public int pop() {
        Node temp = head = tail;
        if (isEmpty()){
            System.out.println("Data Kosong!!!");
            return -1;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return 1;
    }

    public String dequeue(){
        Node node = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
        return node.data;
    }

    public String size(){
        return "a";
    }

    public String cetak(){
        return "a";
    }

    public String peekStack(){
        return "a";
    }

    public String peekQueue(){
        if (!isEmpty()){
            return head.data;
        }else {
            return head.data;
        }
    }

}
