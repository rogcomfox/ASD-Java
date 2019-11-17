package com.nusantarian.laporan.bab2;

public class AppPr1 {

    public static void main(String[] args) {
        double[] A = {3, 4, 1, 10, 5, 2, 10, 20, 16};
        double[] B = {4, 3, 1, 11, 7};

        Larik1 L1 = new Larik1(A);
        Larik1 L2 = new Larik1(B);
        L1.cetak("Isi Larik L1");
        L2.cetak("Isi Larik L2");

        Larik1 L3 = Larik1.sambung(L1, L2);
        L3.cetak("L3 = gabungan dari L1 dan L2");

        Larik1 L4 = Larik1.copyLarik(0, L1.getSize(), L1);
        L1.cetak("Isi Larik L1");
        L4.cetak("L4 copy dari L1");

        Larik1 L5 = Larik1.SelectionSort(L1, 0);
        L5.cetak("L5 Hasil pengurutan dari L1 kecil -> besar");

        Larik1 L6 = Larik1.SelectionSort(L1, 1);
        L6.cetak("L6 Hasil pengurutan dari L1 besar -> kecil");
        L1.cetak("Isi Larik L1");
        double hasil = Larik1.LarikKaliLarik(L1, L4);
        System.out.printf("HASIL KALI Larik L1*L4 = %.3f\n", hasil);
    }
}

