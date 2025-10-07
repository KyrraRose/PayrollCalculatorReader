package com.pluralsight;

import java.io.*;

public class PoemReader {
    public static void main(String[] args) {
    try{
        FileReader littleLamb = new FileReader("src/main/resources/mary_had_a_little_lamb.txt");
        BufferedReader buffReader = new BufferedReader(littleLamb);

        String input;
        while((input=buffReader.readLine())!=null){
            System.out.println(input);
        }
        buffReader.close();

    }catch(IOException e){
        e.printStackTrace();
    }
    }
}
