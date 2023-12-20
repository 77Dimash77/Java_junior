package Lections;

import java.io.*;

public class Lec3_1 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String s = (String) objectInputStream.readObject();
        System.out.println(s);
    }
}
