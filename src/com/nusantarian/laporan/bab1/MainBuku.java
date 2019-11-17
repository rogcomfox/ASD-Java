package com.nusantarian.laporan.bab1;

public class MainBuku {
    public static void main(String[] args) {
        Buku book1 = new Buku("\"Naruto Shippuden\"", "Anime", 3000, 1000, 20, 3);
        Buku book2 = new Buku("\"Mesin Perang\"", "Teknologi", 4000, 2000, 60, 2);
        Buku book3 = new Buku("\"Resep Sehat\"", "Kuliner", 5000, 3000, 30, 5);
        Buku book4 = new Buku("\"Pemrograman Java\"", "Komputer", 1500, 500, 60, 4);
        System.out.println(book1);
        System.out.println();
        System.out.println(book2);
        System.out.println();
        System.out.println(book3);
        System.out.println();
        System.out.println(book4);
    }
}
