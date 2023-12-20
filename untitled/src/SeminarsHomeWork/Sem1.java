package SeminarsHomeWork;

import java.util.Arrays;
import java.util.List;

public class Sem1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double averageOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Среднее значение четных чисел: " + averageOfEvenNumbers);
    }
}
