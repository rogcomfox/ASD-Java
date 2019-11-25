package com.nusantarian.tugas;

class Nodes{
    int data;
    Nodes left;
    Nodes right;
    int height;
    Nodes top;

    Nodes(){
        data = height = 0;
        right = left = top = null;
    }
    Nodes(int data){
        this.data = data;
        height = 1;
        right = left = top = null;
    }
}

public class AvlTree {
    Nodes root;

    public void insertAVL(int data){
        Nodes node = insertNode(data);
        cek(node);
    }

    public int Height(Nodes in){
        if (in == null) return 0;
        else return in.height;
    }

    public void cek(Nodes node){
        while (node != null){
            if (Math.abs(Height(node.left) - Height(node.right)) <= 1){
                addHeight(node);
            }
        }
    }

    public void addHeight(Nodes node){
        node.height = Math.max(Height(node.left), Height(node.right) + 1);
    }

    public Nodes insertNode(int data){
        Nodes in = new Nodes();
        Nodes temp = root;
        Nodes prev = null;
        if(root == null){
            root = in;
            return root;
        }
        while(temp != null){
            prev = temp;
            if(in.data < temp.data)
                temp = temp.left;
            else
                temp = temp.right;
        }
        in.top = prev;

        if(in.data < prev.data ) prev.left = in;
        else prev.right = in;
        return in;
    }

    public int maxDepth(Nodes node){
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        tree.insertNode(5);
        tree.insertNode(4);
        tree.insertNode(3);
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(7);
        System.out.println("Kedalaman Maksimum = "+tree.maxDepth(tree.root));
    }
}

