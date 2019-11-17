package com.nusantarian.laporan.bab7;

import java.util.Scanner;

public class stack_array {
    private static int MAX_SIZE = 10;
    private static char[] arr_stack = new char[MAX_SIZE];
    private static int count = 0;
    private static int keluar = 0;

    private static void push(char item){
        if (count == MAX_SIZE){
            System.out.print("\n#Stack Penuh");
        }else {
            arr_stack[count] = item;
            System.out.print("\n# PUSH No urut/index : " + count + ", Push : " + item);
            count++;
        }
    }

    private static void pop(){
        if (count == 0){
            System.out.print("\n##Stack kosong");
        }else{
            --count;
            System.out.print("\n##POP No urut/index : " + count + ", Value : " + arr_stack[count]);
        }
    }

    private static void printAll(){
        System.out.print("\n##Stack Size: "+count);
        int i;
        for (i = (count - 1); i >= 0; i--){
            System.out.print("\n## No Urut/index: "+ i +", Value: "+arr_stack[i]);
        }
    }

    private static void menu(){
        Scanner masuk = new Scanner(System.in);
        System.out.print("\nMasukkan operasi yang akan dilakukan (1:push, 2:pop, 3:print): ");
        int choice = masuk.nextInt();
        switch (choice){
            case 1:
                System.out.print("\nMasukkan huruf yang akan dipush: ");
                char item = masuk.next().charAt(0);
                push(item);
                break;
            case 2:
                pop();
                break;
            case 3:
                printAll();
                break;
            default:
                System.out.print("\n1:push, 2:pop, 3:print\n");
                keluar = 1;
                break;
        }
    }

    public static void main(String[] args) {
        do {
            menu();
        }while (keluar == 0);
    }
}
