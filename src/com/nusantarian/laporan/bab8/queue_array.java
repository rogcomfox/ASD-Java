package com.nusantarian.laporan.bab8;

import java.util.Scanner;

public class queue_array {
    private static Scanner masuk = new Scanner(System.in);
    private static int i;
    private static int MAX_SIZE = 10;
    private static char[] arr_stack = new char[MAX_SIZE];
    private static int keluar = 0;
    private static int rear=0;

    private static void enqueue(char item) {
        if (rear == MAX_SIZE) {
            System.out.print ( "\n# Queue Penuh");
        } else {
            System.out.print ( "\n# Queue No urut/index : "+ rear+ ", Queue :" + item);
            arr_stack[rear++] = item;
        }
    }

    private static void dequeue() {
        if (rear == 0) System.out.print("\n## Queue kosong");
        else {
            System.out.print ( "\n##Dequeue Value :" + arr_stack[0]);
            for(i=1;i<=rear;i++) {
                char temp=arr_stack[i]; arr_stack[i-1]=temp;
            }
            rear--;
        }
    }

    private static void printAll() {
        System.out.print ( "\n## Queue Size : " + rear);
        for (i = 0; i < rear; i++) System.out.print ( "\n## No Urut/index : " + i +", Value :" + arr_stack[i]);
    }

    private static void menu() {
        System.out.print ( "\nMasukkan operasi yang akan dilakukan (1:enqueue, 2:dequeue, 3:print) : ");
        int choice = masuk.nextInt();
        switch (choice) {
            case 1:
                System.out.print ( "\nMasukkan huruf yang akan di-enqueue : ");
                char item = masuk.next().charAt(0);
                enqueue(item);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                printAll();
                break;
            default:
               System.out.print ( "\n1:enqueue, 2:dequeue, 3:print\n");
               keluar = 1;
               break;
        }
    }

    public static void main(String[] args) {
        do {
            menu();
        } while (keluar == 0); }
}
