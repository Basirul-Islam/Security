package com.Bashir;

public class ByteCodeGenerator {
    String s;
    //char ch = 'A';            // 2 bytes
    // byte b1 = ch;          // error, 2 bytes to 1 byte
    public ByteCodeGenerator(String s){
        this.s = s;
    }
    public StringBuilder generator(){
        //byte b1 = (byte) ch;      // explicit conversion from char to byte


       // System.out.println("char value: " + s);            // prints A
       // System.out.println("Converted byte value: " + s.getBytes());  // prints 65 (ASCII value A)

        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        //System.out.println("'" + s + "' to binary: " + binary);

        return binary;
    }

}
