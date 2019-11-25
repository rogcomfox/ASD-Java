package com.nusantarian.laporan.bab10;

class Node {
    int data;
    int tinggi;
    Node pKiri;
    Node pKanan;
    Node pInduk;

    public Node(int data, int tinggi, Node pKiri, Node pKanan, Node pInduk) {
        this.data = data;
        this.tinggi = tinggi;
        this.pKiri = pKiri;
        this.pKanan = pKanan;
        this.pInduk = pInduk;
    }
}

public class AVLT {
    private Node root;

    public AVLT() {
        root = null;
    }

    public boolean cariDt(int dt) {
        Node temp = root;
        while (temp != null) {
            if (dt == temp.data) return true;
            else if (dt < temp.data) temp = temp.pKiri;
            else temp = temp.pKanan;
        }
        return false;
    }

    public boolean sisipDt(int dt) {
        if (root == null) {
            root = new Node(dt, 1, null, null, null);
            return true;
        } else {
            Node temp = root;
            Node prev = null;
            while (temp != null) {
                if (dt == temp.data) return false;
                else if (dt < temp.data) {
                    prev = temp;
                    temp = temp.pKiri;
                } else {
                    prev = temp;
                    temp = temp.pKanan;
                }
            }
            temp = new Node(dt, 1, null, null, prev);

            if (dt < prev.data) prev.pKiri = temp;
            else prev.pKanan = temp;
            while (temp != null) {
                if (Math.abs(tinggi(temp.pKiri) - tinggi(temp.pKanan)) <= 1) {
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2 && tinggi(temp.pKiri.pKiri) >= tinggi(temp.pKiri.pKanan)) {
                    Node parent = temp.pInduk;
                    Node pKiri = temp.pKiri;
                    temp.pKiri = pKiri.pKanan;
                    if (temp.pKiri != null) temp.pKiri.pInduk = temp;
                    pKiri.pKanan = temp;
                    temp.pInduk = pKiri;
                    pKiri.pInduk = parent;
                    if (parent == null) root = pKiri;
                    else if (parent.pKiri == temp) parent.pKiri = pKiri;
                    else parent.pKanan = pKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } else if (tinggi(temp.pKanan) - tinggi(temp.pKiri) >= 2 && tinggi(temp.pKanan.pKanan) >= tinggi(temp.pKanan.pKiri)) {
                    Node parent = temp.pInduk;
                    Node pKanan = temp.pKanan;
                    temp.pKanan = pKanan.pKiri;
                    if (temp.pKanan != null) temp.pKanan.pInduk = temp;
                    pKanan.pKiri = temp;
                    temp.pInduk = pKanan;
                    pKanan.pInduk = parent;
                    if (parent == null) root = pKanan;
                    else if (parent.pKanan == temp) parent.pKanan = pKanan;
                    else parent.pKiri = pKanan;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKanan;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2 && tinggi(temp.pKiri.pKanan) >= tinggi(temp.pKiri.pKiri)) {
                    Node parent = temp.pInduk;
                    Node pKiripKanan = temp.pKiri.pKanan;
                    temp.pKiri.pKanan = pKiripKanan.pKiri;
                    if (temp.pKiri.pKanan != null) temp.pKiri.pKanan.pInduk = temp.pKiri;
                    pKiripKanan.pKiri = temp.pKiri;
                    temp.pKiri.pInduk = pKiripKanan;
                    temp.pKiri = pKiripKanan.pKanan;
                    if (temp.pKiri != null) temp.pKiri.pInduk = temp;
                    pKiripKanan.pKanan = temp;
                    temp.pInduk = pKiripKanan;
                    pKiripKanan.pInduk = parent;
                    if (parent == null) root = pKiripKanan;
                    else if (parent.pKiri == temp) parent.pKiri = pKiripKanan;
                    else parent.pKanan = pKiripKanan;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKiripKanan;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                } else if (tinggi(temp.pKanan) - tinggi(temp.pKiri) >= 2 && tinggi(temp.pKanan.pKiri) >= tinggi(temp.pKanan.pKanan)) {
                    Node parent = temp.pInduk;
                    Node pKananpKiri = temp.pKanan.pKiri;
                    temp.pKanan.pKiri = pKananpKiri.pKanan;
                    if (temp.pKanan.pKiri != null) temp.pKanan.pKiri.pInduk = temp.pKanan;
                    pKananpKiri.pKanan = temp.pKanan;
                    temp.pKanan.pInduk = pKananpKiri;
                    temp.pKanan = pKananpKiri.pKiri;
                    if (temp.pKanan != null) temp.pKanan.pInduk = temp;
                    pKananpKiri.pKiri = temp;
                    temp.pInduk = pKananpKiri;
                    pKananpKiri.pInduk = parent;
                    if (parent == null) root = pKananpKiri;
                    else if (parent.pKanan == temp) parent.pKanan = pKananpKiri;
                    else parent.pKiri = pKananpKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKananpKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                temp = temp.pInduk;
            }
            return true;
        }
    }

    public int tinggi() {
        return root.tinggi;
    }

    private int tinggi(Node node) {
        if (node == null) return 0;
        else return node.tinggi;
    }

    public int jumlahNode() {
        return jumlahNode(root);
    }

    private void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node r) {
        if (r == null) return;
        inOrder(r.pKiri);
        System.out.printf("-%d", r.data);
        inOrder(r.pKanan);
    }

    private int jumlahNode(Node node) {
        if (node == null) return 0;
        else return 1 + jumlahNode(node.pKiri) + jumlahNode(node.pKanan);
    }

    public static int findMaxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findMaxDepth(root.pKiri), findMaxDepth(root.pKanan));
    }

    public static void main (String[] args) {
        AVLT t = new AVLT();
        t.sisipDt(3);t.inOrderTraversal();System.out.println();
        t.sisipDt(4);t.inOrderTraversal();System.out.println();
        t.sisipDt(6); t.inOrderTraversal();System.out.println();
        t.sisipDt(5); t.inOrderTraversal();System.out.println();
        t.sisipDt(15); t.inOrderTraversal();System.out.println();
        t.sisipDt(10); t.inOrderTraversal();System.out.println();
        t.sisipDt(20); t.inOrderTraversal();System.out.println();
        t.sisipDt(17); t.inOrderTraversal();System.out.println();
        t.sisipDt(25);t.inOrderTraversal();System.out.println();
        System.out.println("Ketinggian Maksimum = " + findMaxDepth(t.root));
    }
}
