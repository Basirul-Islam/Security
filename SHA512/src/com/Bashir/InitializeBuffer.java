package com.Bashir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class InitializeBuffer {

    FileOutputStream fout=null;
    FileInputStream fin = null;

    public InitializeBuffer() {
        /*try{
            fout = new FileOutputStream(new File("InitialBuffer.txt"));
        }catch (Exception e){
            System.out.println(e);
        }*/


    }
    public void fillBuffer(){
        int tmp;
        String buffers = "";
        try {
            fin = new FileInputStream(new File("InitialBuffer.txt"));

            while(fin.available()!=0)
            {
                tmp = fin.read();
                buffers = buffers + (char)tmp;
            }

            System.out.println("\nbuffers: " + buffers);
            char [] stringToCharArray = buffers.toCharArray();
            System.out.println("size of buffers in hexa: " + stringToCharArray.length);
            int j = 0;
            String y = "";
            for (int i =0; i<stringToCharArray.length;i++){
                if(stringToCharArray[i] == ' '){
                    System.out.println("" + (char)(97+j) + " = " + y);
                    HexToBinary h = new HexToBinary(y);
                    h.initializeHexa();
                    y = "";
                    j++;
                }
                /*else if(i==134){
                    System.out.println("" + (char)(97+j) + " = " + y);
                    HexToBinary h = new HexToBinary(y);
                    h.initializeHexa();
                    y = "";
                    j++;
                }*/
                else{
                    y = y + stringToCharArray[i];
                }


            }
            /*ByteCodeGenerator b = new ByteCodeGenerator(buffers);
            System.out.println("\nBuffers to Binary: " + b.generator());
            String binaryOfBuffers = String.valueOf(b.generator()).replace(" ","");
            System.out.println("\nBuffers to Binary after replacing space: " + binaryOfBuffers);

            //char [] stringToCharArray = binaryOfBuffers.toCharArray();
            int j = 0,i = 0;
            System.out.println("size of buffers in bit: " + stringToCharArray.length);
            while (true){
                String x = "" + (char)(97+j);
                String y = "";
                while (true){
                    y = y + stringToCharArray[i];
                    i++;
                    if((i%63) == 0){
                        System.out.println(x + " = " +binaryToText(y) + "\n");
                        j++;
                        //y = "";
                        break;
                    }
                }
                if(i == 511) break;
                    */
               /* for(int i =0; i<512;i++){

                }
            }*/


        } catch (Exception e){
            System.out.println(e);
        }

    }












    public String binaryToText(String s){
        String input = s; // Binary input as String
        StringBuilder sb = new StringBuilder(); // Some place to store the chars

        Arrays.stream( // Create a Stream
                input.split("(?<=\\G.{8})") // Splits the input string into 8-char-sections (Since a char has 8 bits = 1 byte)
        ).forEach(x -> // Go through each 8-char-section...
                sb.append((char) Integer.parseInt(x, 2)) // ...and turn it into an int and then to a char
        );

        String output = sb.toString(); // Output text (t)

        return output;
    }


}
