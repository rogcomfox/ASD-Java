package com.nusantarian.remedial;

class Node {
    Node next;
    private int data;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class DetectLoop {

    private static Node head;

    private static void add(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private static boolean isLoop(Node node) {
        if (node == null) return false;
        Node slow;
        Node fast;
        slow = fast = node;
        while (true) {
            slow = slow.next;
            if (node.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == null || fast == null) return false;

            if (slow == fast) return true;
        }
    }

    public static void main(String[] args) {
        add(30);
        add(40);
        add(25);
        add(10);
        //Test Looping
        head.next.next.next.next = head;
        if (isLoop(head)){
            System.out.println("Terdapat Loop");
        } else {
            System.out.println("Tidak Ada Loop");
        }
    }
}