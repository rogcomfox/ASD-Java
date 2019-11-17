package com.nusantarian.laporan.bab4;

public class Buku {
    String kategori, judul;
    double hargaSewa;
    double hargaDenda;

    public Buku(String kategori, String judul, double hargaSewa, double hargaDenda) {
        this.kategori = kategori;
        this.judul = judul;
        this.hargaSewa = (double)hargaSewa;
        this.hargaDenda = (double)hargaDenda;
    }

    public String getKategori() {
        return kategori;
    }

    public String getJudul() {
        return judul;
    }

    public Double getHargaSewa() {
        return hargaSewa;
    }

    public double getHargaDenda() {
        return hargaDenda;
    }

}
