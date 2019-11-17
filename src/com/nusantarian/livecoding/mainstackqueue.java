package com.nusantarian.livecoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainstackqueue {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        StringBuilder result= new StringBuilder();
        StackQueue sq=new StackQueue();
        for (int i = 0; i <n ; i++) {
            String[]query=in.readLine().split(" ");
            if(query[0].equals("Add")){
                sq.add((query[1]));
            }
            else if(query[0].equals("pop")){
                result.append(sq.pop()).append("\n");
            }
            else if(query[0].equals("dequeue")){
                result.append(sq.dequeue()).append("\n");
            }
            else if(query[0].equals("peekStack")){
                result.append(sq.peekStack()).append("\n");
            }
            else if(query[0].equals("peekQueue")){
                result.append(sq.peekQueue()).append("\n");
            }
            else if(query[0].equals("size")){
                result.append(sq.size()).append("\n");
            }
            else if(query[0].equals("cetak")){
                result.append(sq.cetak());
            }
        }
        System.out.print(result);
    }
}
