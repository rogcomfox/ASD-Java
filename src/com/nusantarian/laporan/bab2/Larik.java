package com.nusantarian.laporan.bab2;

public class Larik {

    private int size;
    private int[] itemDt;

    public void buatLarik(int n) {
        this.size = n;
        this.itemDt = new int[this.size];
    }

    public Larik(int n) {
        buatLarik(n);
    }

    public int getSize() {
        return this.size;
    }

    public Larik(int[] dt) {
        buatLarik(dt.length);
        for (int i = 0; i < dt.length; i++) {
            isiItem(i, dt[i]);
        }
    }

    public void isiItem(int id, int dt) {
        this.itemDt[id] = dt;
    }

    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.itemDt[i] + " ");
        }
        System.out.println();
    }

    public int findBesar() {
        int besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    public int getPosisi(int dtCari) {
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

    private int getPosMax(int id) {
        int max = this.itemDt[id];
        int posMax = id;
        for (int i = id + 1; i < size; i++) {
            if (max <= this.itemDt[i]) {
                max = this.itemDt[i];
                posMax = i;
            }
        }
        return posMax;
    }

    private int getPosMin(int id) {
        int min = this.itemDt[id];
        int posMin = id;
        for (int i = id + 1; i < size; i++) {
            if (min >= this.itemDt[i]) {
                min = this.itemDt[i];
                posMin = i;
            }
        }
        return posMin;
    }

    public int PencarianBiner(int dtCari, int awal, int akhir) {
        int pos = -99;
        int tengah = (awal + akhir) / 2;
        if (dtCari < this.itemDt[tengah]) {
            return PencarianBiner(dtCari, awal, tengah);
        } else if (dtCari > this.itemDt[tengah]) {
            return PencarianBiner(dtCari, tengah + 1, akhir);
        } else if (dtCari == this.itemDt[tengah]) {
            return tengah;
        } else {
            return pos;
        }
    }

    public Larik copyLarik(int k, int n) {
        Larik lHasil = null;
        if (n <= this.size - k) {
            lHasil = new Larik(n);
            int j = 0;
            for (int i = k; i < k + n; i++) {
                lHasil.isiItem(j++, this.itemDt[i]);
            }
        }
        return lHasil;
    }

    public Larik SelectionSort(int pilihan) {
        Larik lsort = copyLarik(0, size);
        for (int i = 0; i < lsort.getSize(); i++) {
            int posData;
            if (pilihan == 0) {
                posData = lsort.getPosMin(i);
            } else {
                posData = lsort.getPosMax(i);
            }
            int dt1 = lsort.itemDt[i];
            int dt2 = lsort.itemDt[posData];
            lsort.itemDt[i] = dt2;
            lsort.itemDt[posData] = dt1;
        }
        return lsort;
    }

    // soal 1 A
    public int findPosKelipatan(int x0, int x1, int x2) {
        for (int i = x1; i <= x2; i++) {
            if (itemDt[i] % x0 == 0) {
                System.out.print(i + " ");
            }
        }
        return -1;
    }

    // soal 1 B
    public Larik BubleSort(int pilihan) {
        Larik bsort = copyLarik(0, size);
        for (int i = 1; i < bsort.getSize(); i++) {
            int temp = 0;
            for (int j = 1; j < bsort.getSize(); j++) {
                if (pilihan == 0) {
                    if (bsort.itemDt[i] < bsort.itemDt[i - 1]) {
                        temp = bsort.itemDt[i - 1];
                        bsort.itemDt[i - 1] = bsort.itemDt[i];
                        bsort.itemDt[i] = temp;
                        for (int k = 0; k < bsort.getSize(); k++) {
                            System.out.print(bsort.itemDt[k] + " ");
                        }
                        System.out.println("");
                    }
                } else {
                    if (bsort.itemDt[j] > bsort.itemDt[j - 1]) {
                        temp = bsort.itemDt[j];
                        bsort.itemDt[j] = bsort.itemDt[j - 1];
                        bsort.itemDt[j - 1] = temp;
                        for (int k = 0; k < bsort.getSize(); k++) {
                            System.out.print(bsort.itemDt[k] + " ");
                        }
                        System.out.println("");
                    }
                }
            }
        }
        return bsort;
    }

    public static void main(String[] args) {
        int[] A = {2, 34, 5, 7, 10};
        Larik lA = new Larik(A);
        lA.cetak("Sebelum");
        lA.SelectionSort(0).cetak("Sesudah di sort");
        System.out.println("Mencari posisi kelipatan 2 dari index 0 - 4");
        lA.findPosKelipatan(2, 0, 4);
        System.out.println("\nBubleSort kecil -> besar");
        Larik lB = lA.BubleSort(0);
        lB.BubleSort(0).cetak("Hasil BubleSort: ");
        System.out.println("BubleSort besar -> kecil");
        lB.BubleSort(1).cetak("Hasil BubleSort: ");
    }
}

