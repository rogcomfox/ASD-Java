package com.nusantarian.tugas;

public class MergeSort {
    //method untuk dipanggil pada method main
    private static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    //algoritma dari merge-sort
    private static void merge(int[] arr, int left, int mid, int right) {
        //membuat array sementara untuk array kiri dan kanan
        int[] left_arr = new int[mid - left + 1];
        int[] right_arr = new int[right - mid];
        //mengisi pada array sementara
        if (left_arr.length >= 0) System.arraycopy(arr, left, left_arr, 0, left_arr.length);
        for (int i = 0; i < right_arr.length; i++) {
            right_arr[i] = arr[mid + i + 1];
        }
        int left_index = 0;
        int right_index = 0;

        for (int i = left; i < right + 1; i++) {
            if (left_index < left_arr.length && right_index < right_arr.length) {
                if (left_arr[left_index] < right_arr[right_index]) {
                    arr[i] = left_arr[left_index];
                    left_index++;
                } else {
                    arr[i] = right_arr[right_index];
                    right_index++;
                }
            }
            else if (left_index < left_arr.length){
                //ketika elemen dari array kanan telah terkopi, kopi sisa index array kiri
                arr[i] = left_arr[left_index];
                left_index++;
            }
            else if (right_index < right_arr.length){
                //ketika elemen dari array kiri telah terkopi, kopi sisa indeks array kanan
                arr[i] = right_arr[right_index];
                right_index++;
            }
        }
    }
    //merubah nilai array String pada integer
    private static String ArraytoInteger(int[] arr){
        if (null == arr || 0 == arr.length) return " ";
        StringBuilder s = new StringBuilder();
        s.append(arr[0]);
        for (int i = 1; i < arr.length; i++) s.append(" ").append(arr[i]);
        return s.toString();
    }

    public static void main(String[] args) {
        int[] sample_arr = {6, 8, 4, 9, 5, 3, 7, 8, 1};
        System.out.println("Array Sebelum Di Sorting\n" + ArraytoInteger(sample_arr));
        mergeSort(sample_arr, 0, sample_arr.length - 1);
        System.out.println("Array Sesudah Di Sorting\n" + ArraytoInteger(sample_arr));
    }
}
