package com.nusantarian.laporan.bab4;

class Node {
    Buku data;
    Node next;

    public Node() {

    }
}


public class SingleLinkedList {
    private Node head;
    private Node tail;

    public void sisipDidepan(Buku dt) {
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        nodeBaru.next = head;

        if (head == null && tail == null) {
            head = nodeBaru;
            tail = nodeBaru;
        } else {
            nodeBaru.next = head;
            head = nodeBaru;
        }
    }

    public boolean sisip(Buku dt1, Buku dt2) {
        Node p = head;
        while (p != null) {
            if (p.data.judul.equals(dt1.getJudul())) {
                Node baru = new Node();
                baru.data = dt2;
                baru.next = p.next;
                p.next = baru;
                break;
            }
            p = p.next;
        }
        return true;
    }

    public void hapusDiDepan() {
        if (head == tail) {
            tail = null;
        }
        head = head.next;
    }

    public void hapusDiAkhir() {
        Node p = head;

        while (p != null) {
            if (p.next.next == null) {
                tail = p;
                tail.next = null;
            }
            p = p.next;
        }
    }

    public void sisipDataDiAkhir(Buku data) {
        if (head == null && tail == null) {
            sisipDidepan(data);
        } else {
            Node nodeBaru = new Node();
            nodeBaru.data = data;
            nodeBaru.next = null;

            tail.next = nodeBaru;
            tail = nodeBaru;
        }
    }

    public void sisipDataUrut(Buku data) {
        Node tmp = new Node();
        tmp.data = data;
        tmp.next = null;
        Node p = head;

        if (head == null) {
            head = tmp;
            tail = tmp;
        } else {
            while (p != null) {
                if (head.data.getHargaSewa() > tmp.data.getHargaSewa()) {
                    tmp.next = head;
                    head = tmp;
                    break;
                } else if (p.data.getHargaSewa() < tmp.data.getHargaSewa() && p.next == null) {
                    tail.next = tmp;
                    tail = tmp;
                    break;
                } else if (p.data.getHargaSewa() < tmp.data.getHargaSewa() && p.next != null && p.next.data.getHargaSewa() > tmp.data.getHargaSewa()) {
                    tmp.next = p.next;
                    p.next = tmp;
                    break;
                } else if (p.data.getHargaSewa() <= tmp.data.getHargaSewa() && p.next != null && p.next.data.getHargaSewa() > tmp.data.getHargaSewa()) {
                    if (p.data.getHargaDenda() < tmp.data.getHargaDenda()) {
                        tmp.next = p.next;
                        p.next = tmp;
                        break;
                    } else {
                        Node baru = new Node();
                        baru.data = data;
                        baru.next = p.next;
                        p.next = baru;
                        break;
                    }
                } else {
                    p = p.next;
                }
            }
        }
        System.out.println("Buku telah dimasukkan\n");
    }

    public void hapusData(Buku dataHapus) {
        Node p = head;

        while (p != null) {
            if (p.next.data == dataHapus) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
    }

    public Node getPointer() {
        return head;
    }

    public static SingleLinkedList gabung(SingleLinkedList L1, SingleLinkedList L2) {
        SingleLinkedList newSLL = new SingleLinkedList();
        Node p = L1.head;
        Node p2 = L2.head;

        while (p != null) {
            newSLL.sisipDataDiAkhir(p.data);
            p = p.next;
        }
        while (p2 != null) {
            newSLL.sisipDataDiAkhir(p2.data);
            p2 = p2.next;
        }
        return newSLL;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        Node n = head;
        while (n != null) {
            System.out.print("Judul Buku : " + n.data.judul);
            System.out.print("\nKategori Buku : " + n.data.kategori);
            System.out.print("\nHarga Sewa Buku : " + n.data.hargaSewa);
            System.out.print("\nHarga Denda Buku : " + n.data.hargaDenda);
            System.out.println("\n--------------------------");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Buku buku1 = new Buku("Komputer", "Pemrograman Java", 2000, 3000);
        Buku buku2 = new Buku("Pendidikan", "Matematika SMA", 2500, 2500);
        Buku buku3 = new Buku("Komputer", "Belajar Microsoft Office", 2000, 7000);
        Buku buku4 = new Buku("Novel", "Laskar Pelangi", 1000, 4000);
        Buku buku5 = new Buku("Komik", "Doraemon", 2000, 5000);
        SingleLinkedList ll = new SingleLinkedList();
        ll.sisipDataUrut(buku1);
        ll.sisipDataUrut(buku2);
        ll.sisipDataUrut(buku3);
        ll.sisipDataUrut(buku4);
        ll.sisipDataUrut(buku5);
        ll.cetak("Linked List Buku\n--------------------------");
    }

}
