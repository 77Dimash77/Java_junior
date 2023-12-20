package Lections;

import java.util.ArrayList;

public class Lec3_3 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> a = new ArrayList<>();
        a = (ArrayList<String>) Lec3_2.deserOb("ser");
        System.out.println(a);
    }
}
