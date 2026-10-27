package com.example.demo;

import com.example.demo.algortimos.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.demo.algortimos.longestSubstring;
import com.example.demo.algortimos.Kadane;
import  com.example.demo.algortimos.AnalisisFinanciero;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

       /* int [] arr = {3, 5, 2, 8, 1};
        int segundoMaximo = SecondMax.secondDistinctMax(arr);
        System.out.println("El segundo valor máximo distinto es: " + segundoMaximo);
*/

        /*String input = "abcabcbb";
        int length = longestSubstring.lengthOfLongestSubstring(input);
        System.out.println("La longitud de la subcadena más larga sin caracteres repetidos es: " + length);
*/

        ReversedLinkedList.Node head = new ReversedLinkedList.Node(1);
        head.next = new ReversedLinkedList.Node(2);
        head.next.next = new ReversedLinkedList.Node(3);
        head.next.next.next = new ReversedLinkedList.Node(4);

        System.out.println("Lista original:");
        printList(head);

        ReversedLinkedList.Node reversedIterative = ReversedLinkedList.Node.reverseIterative(head);
        System.out.println("Lista invertida (iterativa):");
        printList(reversedIterative);

        // Reconstruir la lista para la prueba recursiva
        head = new ReversedLinkedList.Node(1);
        head.next = new ReversedLinkedList.Node(2);
        head.next.next = new ReversedLinkedList.Node(3);
        head.next.next.next = new ReversedLinkedList.Node(4);

        ReversedLinkedList.Node reversedRecursive = ReversedLinkedList.Node.reverseRecursive(head);
        System.out.println("Lista invertida (recursiva):");
        printList(reversedRecursive);
    }

       public static void printList(ReversedLinkedList.Node head) {
           ReversedLinkedList.Node current = head;
           while (current != null) {
               System.out.print(current.data + " ");
               current = current.next;
           }
           System.out.println();





           Kadane kadane = new Kadane();
           int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
           int maxSum = kadane.maxSubArray(array);
           System.out.println("La suma máxima de subarreglo es: " + maxSum);

           // analisis financiero --kandane
           // Ejemplo: Ganancias y pérdidas diarias de una acción en 9 días
           // Día 0: Perdió $2, Día 1: Ganó $1, Día 2: Perdió $3, Día 3: Ganó $4, etc.
           int[] rendimientoAccion = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

           AnalisisFinanciero.ResultadoRacha racha = AnalisisFinanciero.encontrarMejorPeriodo(rendimientoAccion);

           System.out.println("=== REPORTE DE RENDIMIENTO ===");
           System.out.println("Máxima ganancia acumulada obtenida: $" + racha.sumaMaxima);
           System.out.println("La mejor racha continua comenzó en el Día: " + racha.indiceInicio);
           System.out.println("La mejor racha continua terminó en el Día: " + racha.indiceFin);

           // Mostrar los elementos que componen la racha
           System.out.print("Días que componen la racha: [");
           for (int i = racha.indiceInicio; i <= racha.indiceFin; i++) {
               System.out.print(rendimientoAccion[i] + (i == racha.indiceFin ? "" : ", "));
           }
           System.out.println("]");
       }



       }

