package com.nusantarian.referensi;

import java.util.Scanner;
//Mendeklarasikan kelas Node
class Nodes {

    int data;
    Nodes nodeKiri;
    Nodes nodeKanan;

    public Nodes(int dt) {
        data = dt;
        nodeKiri = nodeKanan = null;
    }
//Method untuk menyisipkan data baru pada tree.
//Apabila data baru lebih kecil dari data yang ditunjuk oleh node, maka akan mengakses child kiri.
//Apabila data baru lebih besar dari data yang ditunjuk oleh node, maka akan mengakses child kanan.
    public void sisipDt(int dtSisip) {
        if (dtSisip < data) {
            if (nodeKiri == null) {
                nodeKiri = new Nodes(dtSisip);
            } else {
                nodeKiri.sisipDt(dtSisip);
            }
        } else if (dtSisip > data) {
            if (nodeKanan == null) {
                nodeKanan = new Nodes(dtSisip);
            } else {
                nodeKanan.sisipDt(dtSisip);
            }
        }
    }
}

public class Tree {

    private static Nodes root;

    public Tree() {
        root = null;
    }

//Method untuk menadpatkan jumlah tingkat/level
    public int getTingkat(Nodes node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getTingkat(node.nodeKiri), getTingkat(node.nodeKanan)) + 1;
    }

//Method untuk mencetak node pada level tertentu
    public void CetakLevelTertentu(Nodes node, int level) {
        if (node == null) {
            return;
        }

        if (node.data != 0) {

            if (level == 1) {
                System.out.print(node.data + " ");
                return;
            }
            CetakLevelTertentu(node.nodeKiri, level - 1);
            CetakLevelTertentu(node.nodeKanan, level - 1);
        }
    }

//Method untuk mencetak node dari semua level/tingkatan
    public void CetakSemua(Nodes node) {
        if (node == null) {
            return;
        }

        int tingkat = getTingkat(node);
        for (int i = 0; i <= tingkat; i++) {
            System.out.print("Level " + i + ": ");
            CetakLevelTertentu(node, i + 1);
            System.out.println();
        }
    }

//Method untuk menyisipkan data baru pada Tree
    public void sisipDtNode(int dtSisip) {
        if (root == null) {
            root = new Nodes(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
    }

//Method main
    public static void main(String[] args) {
        Tree tree = new Tree();
        int nilai;
        Scanner in = new Scanner(System.in);
        do {
            //Meminta input data node dari user
            nilai = in.nextInt();
            //Memasukkan nilai inputan user ke dalam Tree
            tree.sisipDtNode(nilai);
            //Apabila input dari user adalah 0, maka akan keluar dari loop
        } while (nilai != 0);
        System.out.println();
        //Setelah keluar dari root, akan mencetak semua node yang ada pada Tree sesuai dengan tingkatan/level masing-masing
        tree.CetakSemua(root);
    }
}
