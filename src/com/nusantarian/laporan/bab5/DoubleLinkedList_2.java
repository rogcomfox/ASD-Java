package com.nusantarian.laporan.bab5;

import com.nusantarian.laporan.bab4.Buku;

import java.util.Scanner;

public class DoubleLinkedList_2 {
    class NodeDLL {

        Buku data;
        NodeDLL prev, next;
    }

    private NodeDLL pKepala, pEkor;

    public DoubleLinkedList_2() {
        pKepala = null;
        pEkor = null;
    }

    public void sisipDipKepala(Object dt) {
        NodeDLL baru = new NodeDLL();
        baru.data = (Buku) dt;
        if (pKepala == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.next = pKepala;
            pKepala.prev = baru;
            pKepala = baru;
        }
    }

    public void sisipDipEkor(Object data) {
        NodeDLL baru = new NodeDLL();
        baru.data = (Buku) data;
        if (pEkor == null) {
            baru.prev = pKepala;
            baru.next = pEkor;
            pKepala = baru;
            pEkor = baru;
        } else {
            baru.prev = pEkor;
            pEkor.next = baru;
            pEkor = baru;
        }
    }

    public void cetak(String kom) {
        System.out.printf("%48s\n", kom);
        NodeDLL p = pKepala;
        int size = 1;
        System.out.println("================================"
                + "===========================================");
        System.out.printf("%-3s| %-20s | %-15s | %-15s | %-15s\n",
                "No", "Judul Buku", "Kategori Buku", "Harga Sewa", "Harga Denda");
        if (p == null) {
            System.out.printf("%-3s", "?");
            System.out.printf("| %-20s ", "?");
            System.out.printf("| %-15s ", "?");
            System.out.printf("| %-15s ", "?");
            System.out.printf("| %-15s \n", "?");
            return;
        }
        while (p != pEkor.next) {
            System.out.printf("%-3d", size);
            System.out.printf("| %-20s ", p.data.getJudul());
            System.out.printf("| %-15s ", p.data.getKategori());
            System.out.printf("| %,-15.0f ", p.data.getHargaSewa());
            System.out.printf("| %,-15.0f \n", p.data.getHargaDenda());
            p = p.next;
            size++;
        }
    }

    // Soal
    public boolean isEmpty() {
        return (pKepala == null && pEkor == null);
    }

    public int size() {
        NodeDLL p = pKepala;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Data Kosong");
            return;
        }

        System.out.println("Buku " + pKepala.data.getJudul() + " telah terhapus");
        if (pKepala == pEkor) {
            pKepala = pEkor = null;
        } else {
            pKepala = pKepala.next;
            pKepala.prev = null;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Data Kosong");
            return;
        }

        System.out.println("Buku " + pEkor.data.getJudul() + " telah terhapus");
        if (pKepala == pEkor) {
            pKepala = pEkor = null;
        } else {
            pEkor = pEkor.prev;
            pEkor.next = null;
        }
    }

    public void hapusDataTertentu(Object dataHapus) {
        NodeDLL p = pKepala;
        if (!isEmpty()) {
            while (p != null) {
                if (pKepala.data.getJudul().equals(dataHapus)) {
                    removeFirst();
                    break;
                } else {
                    if (p.data.getJudul().equals(dataHapus)) {
                        if (p == pEkor) {
                            removeLast();
                            break;
                        }
                        System.out.println("Buku " + p.data.getJudul() + " telah terhapus");
                        p.prev.next = p.next;
                        p.next.prev = p.prev;
                    }
                }
                p = p.next;
            }
        }
    }

    public void sisipDataTerurut(Object data) {
        NodeDLL newData = new NodeDLL();
        newData.data = (Buku) data;
        if (pKepala == null || newData.data.getHargaSewa() <= pKepala.data.getHargaSewa()) {
            sisipDipKepala(newData.data);
        } else {
            NodeDLL p = pKepala;
            while (p.next != null && newData.data.getHargaSewa() > p.data.getHargaSewa()) {
                if (p.next != null && newData.data.getHargaSewa() < p.next.data.getHargaSewa()) {
                    newData.next = p.next;
                    p.next.prev = newData;
                    newData.prev = p;
                    p.next = newData;
                }
                if (p.next != null && newData.data.getHargaSewa() > p.next.data.getHargaSewa()) {
                    if (p.next.next == null) {
                        sisipDipEkor(newData.data);
                        return;
                    }
                    newData.next = p.next.next;
                    p.next.next.prev = newData;
                    newData.prev = p.next;
                    p.next = newData.prev;
                }
                p = p.next;
            }
            if (p.next == null) {
                sisipDipEkor(newData.data);
            }
        }
    }

    public static void main(String s[]) {
        Scanner in = new Scanner(System.in);
        Buku buku; String pil;
        DoubleLinkedList_2 ll = new DoubleLinkedList_2();
        do {
            System.out.println("----------------------------");
            System.out.println("PROGRAM PERPUSTAKAAN");
            System.out.println("----------------------------");
            System.out.println("1. Sisip Buku Dari Depan");
            System.out.println("2. Sisip Buku Dari Belakang");
            System.out.println("3. Sisip Buku Terurut");
            System.out.println("4. Hapus Buku Dari Depan");
            System.out.println("5. Hapus Buku Dari Belakang");
            System.out.println("6. Hapus Buku Tertentu");
            System.out.println("7. Lihat Banyak Buku");
            System.out.println("8. Lihat Daftar Buku");
            System.out.println("9. EXIT");
            System.out.println("----------------------------");
            System.out.print("Pilihan anda : ");
            pil = in.nextLine();
            switch (pil) {
                case "1": case "2": case "3":
                    System.out.print("Judul buku : ");
                    String judul = in.nextLine();
                    System.out.print("Kategori buku : ");
                    String kategori = in.nextLine();
                    System.out.print("Harga sewa buku : ");
                    double sewa = in.nextDouble();
                    System.out.print("Harga denda buku : ");
                    double denda = in.nextDouble();
                    in.nextLine();
                    buku = new Buku(kategori, judul, sewa, denda);
                    switch (pil) {
                        case "1":
                            ll.sisipDipKepala(buku);
                            break;
                        case "2":
                            ll.sisipDipEkor(buku);
                            break;
                        case "3":
                            ll.sisipDataTerurut(buku);
                            break;
                        default:
                            break;
                    }
                    break;
                case "4":
                    ll.removeFirst();
                    break;
                case "5":
                    ll.removeLast();
                    break;
                case "6":
                    System.out.print("Masukkan Judul : ");
                    String jud = in.nextLine();
                    ll.hapusDataTertentu(jud);
                    break;
                case "7":
                    System.out.println("Total Buku : " + ll.size() + " Buku");
                    break;
                case "8":
                    System.out.println("=================================="
                            + "=========================================");
                    ll.cetak("DAFTAR BUKU PERPUSTAKAAN");
                    System.out.println("=================================="
                            + "=========================================\n");
                    break;
                case "9":
                    System.out.println("TERIMA KASIH");
                    break;
                default:
                    System.out.println("Pilihan anda salah !");
            }
        } while (!pil.equals("9"));
    }

}
