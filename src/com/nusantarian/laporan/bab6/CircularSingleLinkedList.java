package com.nusantarian.laporan.bab6;

class NodeCSLL{
    Object data;
    NodeCSLL setelah;
}

public class CircularSingleLinkedList {
    private NodeCSLL pAwal, pAkhir;
    private int jumlah;

    public CircularSingleLinkedList() {
        pAwal = null;
        pAkhir = null;
        jumlah = -1;
    }

    public void sisipDataDiAwal(Object data){
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;
        if (pAwal == null){
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        }else {
            pBaru.setelah = pAwal;
            pAkhir.setelah = pBaru;
            pAwal = pBaru;
            jumlah++;
        }
    }

    public void sisipDataDiAkhir(Object data){
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;
        if (pAwal == null){
            pAwal = pBaru;
            pAkhir = pBaru;
            jumlah = 0;
        }else {
            pAkhir.setelah = pBaru;
            pBaru.setelah = pAwal;
            pAkhir = pBaru;
            jumlah++;
        }
    }

    public void hapusData(Object dtHapus){
        if (pAwal != null){
            NodeCSLL pSbl, pKini, pHapus;
            pSbl = null;
            pKini = pAwal;
            boolean ketemu = false;
            int i = 0;
            while (!ketemu && (i <= jumlah)){
                if (pKini.data.equals(dtHapus)){
                    ketemu = true;
                }else {
                    pSbl = pKini;
                    pKini = pKini.setelah;
                }
                i++;
            }
            if (ketemu){
                if (pSbl == null){
                    pHapus = pAwal;
                    pAwal = pKini.setelah;
                    pAkhir.setelah = pAwal;
                    pHapus = null;
                }else {
                    if (pAkhir == pKini){
                        pAkhir = pSbl;
                    }
                    pSbl.setelah = pKini.setelah;
                    pHapus = pKini;
                    pHapus = null;
                }
                jumlah--;
            }
        }
    }

    public void hapusSatuDataDiAwal(){
        NodeCSLL temp = pAwal;
        if (pAkhir == pAwal) {
            pAkhir = pAwal = null;
            this.jumlah = -1;
        } else {
            pAwal = pAwal.setelah;
            pAkhir.setelah = pAwal;
            this.jumlah--;
        }
    }

    public void hapusSatuDataDiAkhir(){
        NodeCSLL temp = pAkhir;
        if (pAkhir == pAwal) {
            pAkhir = pAwal = null;
            this.jumlah = -1;
        } else {
            while (temp.setelah != pAkhir) {
                temp = temp.setelah;
            }
            temp.setelah = temp.setelah.setelah;
            pAkhir = temp;
            this.jumlah--;
        }
    }

    public void cetak(String Komentar){
        System.out.println(Komentar);
        NodeCSLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while ((i < jumlah)){
            System.out.print(pCetak.data+"->");
            pCetak = pCetak.setelah;
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        csll.sisipDataDiAwal(50);
        csll.sisipDataDiAwal(60);
        csll.sisipDataDiAwal(70);
        csll.sisipDataDiAwal(8);
        csll.sisipDataDiAwal(9);
        csll.sisipDataDiAwal(90);
        csll.sisipDataDiAwal(19);
        csll.cetak("csll Asal");
        csll.hapusData(8);
        csll.cetak("csll stl 8 dihapus");
        csll.hapusData(90);
        csll.cetak("csll stl 90 dihapus");
    }
}
