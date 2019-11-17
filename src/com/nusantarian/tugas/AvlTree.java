package com.nusantarian.tugas;

class Nodes{
    int data;
    Nodes left, right;
    Nodes(int  data){
        this.data = data;
        left = right = null;
    }
}

public class AvlTree {
    Node root;
    public int Kedalaman(Nodes node){
        if (node == null){
            return 0;
        }else {
            int lefKed = Kedalaman(node.left);
            int riKed = Kedalaman(node.right);
            if (lefKed > riKed){
                return lefKed + 1;
            }else
                return riKed +1;
        }
    }
}

class Main{
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        tree.root = new Node(2);
        tree.root.left = new Node(5);
        tree.root.right = new Node(10);
        tree.root.left.right = new Node(20);
    }
}
