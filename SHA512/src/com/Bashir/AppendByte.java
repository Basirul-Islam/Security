package com.Bashir;

import java.util.ArrayList;
import java.util.Scanner;

public class AppendByte {

    String s;
    StringBuilder binary;
    public AppendByte(String s){
        this.s = s;
        ByteCodeGenerator b1 = new ByteCodeGenerator(s);
        binary = b1.generator();
    }
    public int calcPadding(int m){
        int p = 0,n=0;
        if((m/1024) == 0){
            while (true){
                n++;
                //System.out.println("i am here!");
                p = n*1024-(m+128);
                if(p>0 && p<(1024-128)) return p;
            }
        }
        else if ((m%1024)>128 && (m/1024)>=1) {
            n = (m/1024)+1;
            p = n*1024-(m+128);
            return p;
        }
        else if((m%1024)==0 && (m/1024)>=1) {
            n = (m/1024)+1;
            p = n*1024-(m+128);
            return p;
        }
        else return p;
    }

    public String addPaddingBit(String s, int paddingBitSize){
        s = s + "1";
        for(int i=1; i<=paddingBitSize;i++){
            s = s + "0";
        }

        return s;
    }

    public String addSizebit(String s, int messageSize){

        String mSizeInBinary = Integer.toBinaryString(messageSize);
        for(int i = 1; i <= (128-mSizeInBinary.length()); i++){
            s = s + "0";
        }

        s = s + mSizeInBinary;

        return s;
    }

    public String Appendbit(){


        System.out.println("'" + s + "' to binary: " + binary);
        String s1 = String.valueOf(binary);
        char [] stringToCharArray = s1.toCharArray();
        String s2 = ""; // generate spaceLess String of binary code;
        for(int i = 0; i<stringToCharArray.length;i++){ // for replacing space (hudai)
            if(stringToCharArray[i]!= ' '){
                s2 = s2 + stringToCharArray[i];
            }
        }
        System.out.println("Total bit size: " + s2.length());

        System.out.println("padding bit size: " + calcPadding(s2.length()));
        /*Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();*/
        //System.out.println("padding bit size: " + calcPadding(m));

        System.out.println("after adding Padding bit: " + addPaddingBit(s2,calcPadding(s2.length())));

        System.out.println("after adding sizeBit: " + addSizebit(addPaddingBit(s2,calcPadding(s2.length())),s2.length()));


        return s1;
    }

}
