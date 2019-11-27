package com.nusantarian.remedial;

public class RoundRobin {
    //Mencari Waktu Tunggu semua proses
    private static void cariTunggu(int[] proses, int n, int[] burst, int[] wait, int q) {
        int[] temp_burst = new int[n]; // kopi array burst
        System.arraycopy(burst, 0, temp_burst, 0, n);
        int now = 0;//waktu sekarang

        while (true) {
            boolean selesai = true;
            //mengecek proses satu per satu melalui perulangan
            for (int i = 0; i < n; i++) {
                //proses > 0,
                if (temp_burst[i] > 0) {
                    selesai = false;
                    if (temp_burst[i] > q) {
                        now += q;
                        temp_burst[i] -= q;
                    } else {
                        now += temp_burst[i];
                        wait[i] = now - burst[i];
                        temp_burst[i] = 0;
                    }
                }
            }
            if (selesai) {
                break;
            }
        }
    }

    private static void aroundTime(int n, int[] burst, int[] wait, int[] around) {
        for (int i = 0; i < n; i++) {
            around[i] = burst[i] + wait[i];
        }
    }

    private static void rataTunggu(int[] proses, int n, int[] burst, int q){
        int[] wait = new int[n];
        int[] around = new int[n];
        int tot_tunggu = 0;
        int tot_around = 0;
        cariTunggu(proses, n, burst, wait, q);
        aroundTime(n, burst, wait, around);
        System.out.println("Proses " + "Burst Time " + "Waiting Time " + "Turn Around Time");
        for (int i = 0; i < n; i++){
            tot_around += wait[i];
            tot_tunggu += around[i];
            System.out.println(" " + (i+1) + "\t\t" + burst[i] + "\t " + wait[i] + "\t\t" + around[i]);
        }
        System.out.printf("Rata Rata Waiting Time = %f\n", (float) tot_tunggu / (float) n);
        System.out.printf("Average Turn Around Time = %f", (float) tot_around / (float) n);
    }

    public static void main(String[] args) {
        int[] proses = {1, 2, 3, 4, 5, 6, 7};
        int n = proses.length;
        int[] burst = {10, 5, 8, 8, 9, 10, 6};
        int q = 2;
        rataTunggu(proses, n, burst, q);
    }
}
