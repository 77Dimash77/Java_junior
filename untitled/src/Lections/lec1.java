package Lections;

public class lec1 {
    public static void main(String[] args) {
//    PlainInterface a = new PlainInterface() {
//        @Override
//        public String action(int x, int y) {
//            return String.valueOf(x + y);
//        }
//    };
        PlainInterface1 a = Integer::sum;
        PlainInterface1 b = Integer::compare;

        System.out.println(a.action(2 , 3));
        System.out.println(b.action(2 , 3));
    }
}