package com.example.demo.algortimos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondMax {

    Scanner scanner = new Scanner(System.in);
    {
    List<Integer> numbers = new ArrayList<>();
            System.out.println("Ingrese números (ingrese un número negativo para terminar):");
            while (true) {
        int num = scanner.nextInt();
        if (num < 0) {
            break;
        }
        numbers.add(num);
    }
    int[] arr = numbers.stream().mapToInt(i -> i).toArray();
    int segundoMaximo = SecondMax.secondDistinctMax(arr);
            System.out.println("El segundo valor máximo distinto es: " + segundoMaximo);



}
    public static int secondDistinctMax(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("El arreglo debe contener al menos dos elementos distintos.");
        }

        Integer max = null;
        Integer secondMax = null;

        for (int num : arr) {
            if (max == null || num > max) {
                secondMax = max;
                max = num;
            } else if (num != max && (secondMax == null || num > secondMax)) {
                secondMax = num;
            }
        }

        if (secondMax == null) {
            throw new IllegalArgumentException("No hay un segundo valor máximo distinto en el arreglo.");
        }

        return secondMax;
    }
}