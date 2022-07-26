package org.example;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Raphael Andrade
 * Date: 26/07/2022
 */
public class Main {

    public static void main(String[] args) {

        Integer[] input = {5, 50, 56};

        try {
            System.out.println("Result="+function(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String function(Integer[] numbers) {

        List<Integer> numbersList = Arrays.asList(numbers);
        numbersList = sortArray(numbersList);
        String result = getArrayAsString(numbersList);

        return result;
    }

    private static String getArrayAsString(List<Integer> numbers) {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    static List<Integer> sortArray(List<Integer> numbersList) {
        numbersList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s1+s2).compareTo(s2+s1)*(-1);
            }
        });

        return numbersList;
    }
}
