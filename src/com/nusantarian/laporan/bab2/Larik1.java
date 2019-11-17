package com.nusantarian.laporan.bab2;

public class Larik1 {

    private int size;
    private double[] itemDt;

    public Larik1(double[] A) {
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.itemDt[i] = A[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public double getItem(int i) {
        return this.itemDt[i];
    }

    public static Larik1 sambung(Larik1 l1, Larik1 l2) {
        double[] nCount = new double[(l1.getSize() + l2.getSize())];
        Larik1 nLarik = new Larik1(nCount);
        int counter = 0;
        for (int i = 0; i < l1.getSize(); i++) {
            if ((i + 1) == l1.getSize()) {
                nLarik.isiItem(counter++, l1.getItem(i));
                for (int j = 0; j < l2.getSize(); j++) {
                    nLarik.isiItem(counter++, l2.getItem(j));
                }
                break;
            }
            nLarik.isiItem(counter++, l1.getItem(i));
        }
        return nLarik;
    }

    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%.2f ", this.itemDt[i]);
        }
        System.out.println();
    }

    public double findBesar() {
        double besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    public int getPosisi(double dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public static Larik1 copyLarik(int k, int n, Larik1 l) {
        int counter = 0;
        double[] nCopySize = new double[n];
        Larik1 nCopy = new Larik1(nCopySize);

        for (int i = k; i < k + n; i++) {
            nCopy.isiItem(counter++, l.getItem(i));
        }
        return nCopy;
    }

    public int getPosBesar(int awal, int akhir) {
        int posBesar = -1;
        double itemBesar;
        if (awal <= akhir) {
            posBesar = awal;
            itemBesar = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemBesar < nilaiItem) {
                    itemBesar = nilaiItem;
                    posBesar = i;
                }
            }
        }
        return posBesar;
    }

    public int getPosKecil(int awal, int akhir) {
        int posKecil = -1;
        double itemKecil;
        if (awal <= akhir) {
            posKecil = awal;
            itemKecil = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemKecil > nilaiItem) {
                    itemKecil = nilaiItem;
                    posKecil = i;
                }
            }
        }
        return posKecil;
    }

    public static Larik1 SelectionSort(Larik1 lAsal, int status) {
        int n = lAsal.getSize();
        Larik1 lhasil = Larik1.copyLarik(0, n, lAsal);
        if (status == 0) {// urutkan data dari kecil ke besar
            for (int i = 0; i < n; i++) {
                int posKecil = lhasil.getPosKecil(i, n);
                double itemKecil = lhasil.getItem(posKecil);
                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemKecil);
                lhasil.isiItem(posKecil, itemI);
            }
        } else { // urutkan data dari besar ke kecil
            for (int i = 0; i < n; i++) {
                int posBesar = lhasil.getPosBesar(i, n);
                double itemBesar = lhasil.getItem(posBesar);
                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemBesar);
                lhasil.isiItem(posBesar, itemI);
            }
        }
        return lhasil;
    }

    public static double LarikKaliLarik(Larik1 L1, Larik1 L4) {
        double hasil = 0;
        for (int i = 0; i < L1.getSize(); i++) {
            hasil += L1.getItem(i) * L4.getItem(i);
        }
        return hasil;
    }
}

