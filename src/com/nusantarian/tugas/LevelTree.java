package com.nusantarian.tugas;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right =null;
    }
}

class LevelTree {
    void OrderLevel(Node root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            cetakLevel(root,i);
            System.out.println();
        }
    }
    private void cetakLevel(Node root, int h){
        if(root==null) return;
        if(h==1) System.out.print(" " + root.data);
        else{
            cetakLevel(root.left,h-1);
            cetakLevel(root.right,h-1);
        }
    }
    private int height(Node root){
        if (root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
}

class Test{
    public static void main(String[] args)  {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(11);
        root.left.right = new Node(13);
        root.right.left = new Node(20);
        root.right.right = new Node(25);

        LevelTree lr = new LevelTree();
        lr.OrderLevel(root);
    }
}
