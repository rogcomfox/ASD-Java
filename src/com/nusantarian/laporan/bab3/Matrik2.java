package com.nusantarian.laporan.bab3;

import com.nusantarian.laporan.bab2.Larik1;

public class Matrik2 {
    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matrik2(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik2(double[][] A) {
        this(A.length, A[0].length); // panggil contructor
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDt[i][j] = A[i][j];
            }
        }
    }

    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }

    public static Matrik2 tambah(Matrik2 A, Matrik2 B) {
        Matrik2 y = null;
        if ((A.nBaris == B.getNBaris()) && (A.nKolom == B.getNKolom())) {
            y = new Matrik2(A.getNBaris(), A.getNKolom());
            for (int i = 0; i < A.nBaris; i++) {
                for (int j = 0; j < A.nKolom; j++) {
                    y.setItem(i, j, A.itemDt[i][j] + B.getItem(i, j));
                }
            }
        }
        return y;
    }

    public static Larik1 VektorKaliMatrik(Larik1 L, Matrik2 M) {
        Larik1 lHasil = null;
        Larik1 lKolom = null;
        if (L.getSize() == M.getNBaris()) {
            double[] nMKol = new double[M.getNKolom()];
            lHasil = new Larik1(nMKol);
            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik1.LarikKaliLarik(L, lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, (int) hasil);
            }
        }
        return lHasil;
    }

    public double determinan() {
        double a,b,c,d,e,f;
        if (this.getNBaris()== 2 && this.getNKolom()== 2){
            a = this.getItem(0, 0) * this.getItem(1, 1);
            b = this.getItem(0, 1) * this.getItem(1, 0);
            return a-b;
        }
        if (this.getNBaris()== 3 && this.getNKolom()==3) {
            a = this.getItem(0, 0) * this.getItem(1, 1) * this.getItem(2, 2);
            b = this.getItem(0, 1) * this.getItem(1, 2) * this.getItem(2, 0);
            c = this.getItem(0, 2) * this.getItem(1, 0) * this.getItem(2, 1);
            d = this.getItem(0, 2) * this.getItem(1, 1) * this.getItem(2, 0);
            e = this.getItem(0, 1) * this.getItem(1, 0) * this.getItem(2, 2);
            f = this.getItem(0, 0) * this.getItem(1, 2) * this.getItem(2, 1);
            return (a + b + c) - (d + e + f);
        }
        System.out.println("Bukan Matriks Persehgi");
        return 0;
    }

    public static Matrik2 tranpos(Matrik2 A) {
        Matrik2 a = new Matrik2(A.getNKolom(), A.getNBaris());
        for (int i = 0; i < a.getNBaris(); i++) {
            for (int j = 0; j < a.getNKolom(); j++) {
                a.setItem(i, j, A.itemDt[j][i]);
            }
        }
        return a;
    }

    public Larik1 getBaris(int idBaris) {
        double[] nKol = new double[this.nKolom];
        Larik1 l = new Larik1(nKol);
        for (int i = 0; i < this.nKolom; i++) {
            l.isiItem(i, (int) itemDt[idBaris][i]);
        }
        return l;
    }

    public Larik1 getKolom(int idKolom) {
        double[] nBar = new double[this.nBaris];
        Larik1 l = new Larik1(nBar);
        for (int i = 0; i < this.nBaris; i++) {
            double itemKolom = this.getItem(i, idKolom);
            l.isiItem(i, itemKolom);
        }
        return l;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.printf("%.2f ", this.itemDt[i][j]);
            }
            System.out.println();
        }
    }

}
