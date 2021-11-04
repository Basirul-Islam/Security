package com.Bashir;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.print("Enter the message: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //System.out.println("String: " + s);
        //String s = "";
        //AppendByte appendByte = new AppendByte(s);
        //appendByte.Appendbit();

        /*ByteCodeGenerator bb = new ByteCodeGenerator(s);
        System.out.println("Binary of " + s + ": " + bb.generator() );*/

        InitializeBuffer b = new InitializeBuffer();
        //b.fillBuffer();

        HexToBinary h = new HexToBinary(s);
        h.initializeHexa();

        //System.out.println("binary to text: " + b.binaryToText("010000010100000101000001") + "\n");
    }
}
