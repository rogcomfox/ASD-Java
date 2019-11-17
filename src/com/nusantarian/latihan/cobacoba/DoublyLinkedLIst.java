//package com.nusantarian.latihan.cobacoba;
//
//class DoublyNode{
//    Object data;
//    DoublyNode next;
//    DoublyNode prev;
//
//    public DoublyNode(Object data, DoublyNode next, DoublyNode prev) {
//        this.data = data;
//        this.next = next;
//        this.prev = prev;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    public DoublyNode getNext() {
//        return next;
//    }
//
//    public void setNext(DoublyNode next) {
//        this.next = next;
//    }
//
//    public DoublyNode getPrev() {
//        return prev;
//    }
//
//    public void setPrev(DoublyNode prev) {
//        this.prev = prev;
//    }
//}
//
//public class DoublyLinkedLIst {
//    int size;
//    String head;
//    String tail;
//
//    public DoublyLinkedLIst() {
//        head = tail = null;
//        size = 0;
//    }
//
//    public boolean isEmpty(){
//        return head==null;
//    }
//
//    public void makeEmpty(){
//        head=tail=null;
//        size = 0;
//    }
//
//    public void printToTail(){
//        DoublyNode p = new DoublyNode();
//        while (p!= null){
//            System.out.println(p.data + " ");
//            p = p.prev;
//        }
//        System.out.println("");
//    }
//
//    public void addLast(Object data){
//        DoublyNode baru = new DoublyNode(data);
//        if (isEmpty()){
//            head=tail=baru;
//        }else {
//            baru.prev = tail;
//            tail.next = baru;
//            tail = baru;
//        }
//    }
//}
