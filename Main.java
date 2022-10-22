package com.company;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //Для задания 1
        System.out.println("Задание 1:" + Remainder(4,2));

        //Для задания 2
        System.out.println("Задание 2:" +АreaOfTriangle(5, 8));

        //Для задания 3
        System.out.println("Задание 3:" + Animals(2,5,9));

        //Для задания 4
        System.out.println("Задание 4:" + profitableGamble(4.2,33.99,5.66));

        //Для задания 5
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Задание 5:" + Operation(n, a, b));
        sc.close();

        //Для задания 6
        String s = "M";
        System.out.println("Задание 6:" + ASCII(s));

        //Для задания 7
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        int k = addUpTo(list);
        System.out.println("Задание 7:" + k);

        //Для задания 8
        System.out.println("Задание 8:" + nextEdge(2,7));

        //Для задания 9
        int add = sumOfCubes(new int[]{1,5,9});

        //Для задания 10
        System.out.println("Задание 10:" + abcmath(9,92,53));




    }
    //Задание_1
    public static int Remainder(int a, int b) {
        return a % b;
    }

    //Задание_2
    public static double АreaOfTriangle (double Osn, double Vis) {
        return (Osn * Vis)/2;
    }

    //Задание_3
    public static int Animals(int kol_Chickens, int kol_Cows, int kol_Pigs) {
        return kol_Chickens*2 + kol_Cows*4 + kol_Pigs*4;
    }

    //Задание_4
    public static boolean profitableGamble (double prob, double prize, double pay) {
        if (prob * prize > pay) {
            return true;
        }
        else {
            return false;
        }
    }

    //Задание_5
    public static String Operation (int N, int a, int b) {
        if (a + b == N) {
            return "Сложить";
        }
        else if (a - b == N) {
            return "Вычесть";
        }
        else if (a * b == N) {
            return "Умножить";
        }
        else if (a / b == N) {
            return "Разделить";
        }
         else {
             return "NONE";
        }
    }

    //Задание_6
    public static int ASCII(char s) {
        return s;
    }

    //Задание_7
    public static int addUpTo(ArrayList<Integer> List) {
        int Length = List.size();
        int added = Length;
        while (Length != 0) {
            added += Length - 1;
            Length--;
        }
        return added;
    }

    //Задание_8
    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }

    //Задание_9
    public static int sumOfCubes(int[] array) {
        int Added = 0;
        for (int i = 0; i <array.length; i++ ) {
            Added += Math.pow(array[i], 3);
        }
        return Added;
    }



    //Задание_10
    public static boolean abcmath(int a, int b, int c) {
        for (int i = 1; i < b; i++) {
            a += a;
        }
        if (a % c == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
