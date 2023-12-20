package Lections;

import java.io.*;
import java.util.ArrayList;

public class Lec3_2 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(Character.getName(i));
        }
        serOb(a,"ser");
    }
    public static void serOb(Object o, String file) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
    public static Object deserOb(String file) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    return objectInputStream.readObject();
    }

}
