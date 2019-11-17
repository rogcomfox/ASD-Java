package com.nusantarian.laporan.bab3;

import com.nusantarian.laporan.bab2.Larik;

public class Matrik {
    int nBaris;
    int nKolom;
    double[][] itemDt;

    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double[][] dt) {
        nBaris = dt.length;
        nKolom = dt[0].length;
        this.itemDt = new double[nBaris][nKolom];
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.setItem(i, j, dt[i][j]);
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

    public Matrik tambah(Matrik x) {
        Matrik y = null;
        if ((this.nBaris == x.getNBaris()) && (this.nKolom == x.getNKolom())) {
            y = new Matrik(x.getNBaris(), x.getNKolom());
            for (int i = 0; i < this.nBaris; i++) {
                for (int j = 0; j < this.nKolom; j++) {
                    y.setItem(i, j, this.itemDt[i][j] + x.getItem(i, j));
                }
            }
        }
        return y;
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

    public Matrik transposeMatrik() {
        Matrik a = new Matrik(this.getNBaris(), this.getNKolom());
        for (int i = 0; i < this.getNBaris(); i++) {
            for (int j = 0; j < this.getNKolom(); j++) {
                a.setItem(i, j, this.itemDt[j][i]);
            }
        }
        return a;
    }

    public Matrik kali(Matrik x) {
        Matrik a = new Matrik(this.getNBaris(), x.getNKolom());
        for (int i = 0; i < a.getNBaris(); i++) {
            for (int j = 0; j < a.getNKolom(); j++) {
                double b = 0;
                for (int k = 0; k < a.getNBaris(); k++) {
                    b += this.getItem(i, k) * x.getItem(k, j);
                }
                a.setItem(i, j, b);
            }
        }
        return a;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.print(this.itemDt[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Larik getKolom(int idK) {
        Larik nKol = new Larik(this.nBaris);
        for (int i = 0; i < this.nKolom; i++) {
            nKol.isiItem(i, (int) itemDt[i][idK - 1]);
        }
        return nKol;
    }

    public Larik getBaris(int idB) {
        Larik nBar = new Larik(this.nKolom);
        for (int i = 0; i < this.nBaris; i++) {
            nBar.isiItem(i, (int) itemDt[idB - 1][i]);
        }
        return nBar;
    }

    public static void main(String[] args) {
        Matrik A, B, C;
        double[][] X = {{1, 2, 3}, {2, 14, 5}, {16, 8, 13}};
        double[][] Y = {{10, 12, 0}, {5, 1, 5}, {3, 1, 10}};
        A = new Matrik(X);
        B = new Matrik(Y);
        A.cetak("Matrik A");
        B.cetak("Matrik B");
        C = A.tambah(B);
        C.cetak("Matrik C = A + B");
        C.transposeMatrik().cetak("Transpos C :");
        System.out.println("Determinan C :" + C.determinan());
        Larik lb;
        Larik lk;
        lb = C.getBaris(1);
        lb.cetak("Larik baris ke-1");
        lk = C.getKolom(1);
        lk.cetak("Larik kolom ke-1");
    }

}
