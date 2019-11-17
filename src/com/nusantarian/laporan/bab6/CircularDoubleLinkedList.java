package com.nusantarian.laporan.bab6;

class NodeCDLL{
    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;
}

public class CircularDoubleLinkedList {
    private NodeCDLL pAwal, pAkhir;
    private int jumlah;

    public CircularDoubleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        } else {
            pBaru.sebelum = pAkhir;
            pBaru.setelah = pAwal;
            pAwal.sebelum = pBaru;
            pAkhir.setelah = pBaru;
            pAkhir = pBaru;
            jumlah++;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal != null) {
            NodeCDLL temp = pAwal;
            while (!temp.data.equals(dtHapus)) {
                temp = temp.setelah;
            }
            if (temp == pAwal) {
                temp.setelah.sebelum = temp.sebelum;
                temp.sebelum.setelah = temp.setelah;
                pAwal = temp.setelah;
                this.jumlah--;
            } else if (temp == pAkhir) {
                temp.setelah.sebelum = temp.sebelum;
                temp.sebelum.setelah = temp.setelah;
                pAkhir = temp.sebelum;
                this.jumlah--;
            } else {
                temp.setelah.sebelum = temp.sebelum;
                temp.sebelum.setelah = temp.setelah;
                this.jumlah--;
            }
        }
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCDLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while ((i < jumlah)) {
            System.out.print(pCetak.data + "->");
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.SisipDataDiAwal(50);
        cdll.SisipDataDiAwal(60);
        cdll.SisipDataDiAwal(70);
        cdll.SisipDataDiAwal(8);
        cdll.SisipDataDiAwal(9);
        cdll.SisipDataDiAwal(90);
        cdll.SisipDataDiAwal(19);
        cdll.cetak("cdll Asal");
    }
}
