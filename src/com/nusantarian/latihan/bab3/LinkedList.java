package com.nusantarian.latihan.bab3;

public class LinkedList {
    int data;
    LinkedList next;
    LinkedList head, tail;
    LinkedList prev;

    public void add(int data){
        LinkedList node = new LinkedList();
        node.data = data;
        if (head==null){
            head=node;
            tail=node;
        }else {
            if (head==tail){
                head.next=node;
                node=tail;

            }
        }
    }
}
