package com.nusantarian.laporan.bab3;

import com.nusantarian.laporan.bab2.Larik1;

public class MainMatrik2 {
    public static void main(String[] args) {
        Matrik2 A, B, C;
        double[][] data1 = {{1, 2, 3}, {3, 4, 7}};
        double[][] data2 = {{4, 5, 1}, {6, 1, 9}};
        A = new Matrik2(data1);
        B = new Matrik2(data2);
        A.cetak("A");
        B.cetak("B");
        C = Matrik2.tambah(A, B);
        C.cetak("C");
        System.out.println("Determinan C : "+C.determinan());
        Matrik2 CT = Matrik2.tranpos(C);
        CT.cetak("Tranpos");
        Larik1 l1 = C.getBaris(1);
        l1.cetak("Baris ke 1 dari C");
        Larik1 l2 = Matrik2.VektorKaliMatrik(l1, CT);
        l2.cetak("Hasil kali C.L1");
    }

}
