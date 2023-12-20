package Lections;

import java.io.Serializable;

public class Lec3_4 {
    public static void main(String[] args) throws Exception {
        GG a = new GG("iv", "Dez", "Slo");
        Lec3_2.serOb(a,"ser");

        GG b= (GG) Lec3_2.deserOb("ser");
        System.out.println(b);

    }

    static class GG implements Serializable {
        String llname;
        String fname;
        String param;

        public GG(String lname, String fname, String param) {
            this.llname = lname;
            this.fname = fname;
            this.param = param;
        }

        @Override
        public String toString() {
            return "Lections.Lec3_4{" +
                    "lname='" + llname + '\'' +
                    ", fname='" + fname.toUpperCase().charAt(0) + '\'' +
                    ", param='" + param.toUpperCase().charAt(0)+ '\'' +
                    '}';
        }
    }

}

