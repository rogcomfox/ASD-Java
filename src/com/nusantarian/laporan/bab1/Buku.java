package com.nusantarian.laporan.bab1;

public class Buku {
    private String judul, tipe;
    private int biayaSewa, denda, daySewa, dayDenda;

    Buku(String judul, String tipe, int biayaSewa, int denda, int daySewa, int dayDenda) {
        this.judul = judul;
        this.tipe = tipe;
        this.biayaSewa = biayaSewa;
        this.denda = denda;
        this.daySewa = daySewa;
        this.dayDenda = dayDenda;
    }

    private String getJudul() {
        return judul;
    }

    private String getTipe() {
        return tipe;
    }

    private int getBiayaSewa() {
        return biayaSewa * getDaySewa();
    }

    private int getDenda() {
        return denda * getDayDenda();
    }

    private int getDaySewa() {
        return daySewa;
    }

    private int getDayDenda() {
        return dayDenda;
    }

    @Override
    public String toString(){
        return String.format("Peminjaman %s %s selama %d hari akan menghasilkan biaya sebesar Rp. %d,00 \nApabila Terlambat %d hari, maka peminjaman wajib membayar denda sebesar Rp. %d,00", getTipe(), getJudul(), getDaySewa(), getBiayaSewa(), getDayDenda(), getDenda());
    }
}
