package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1: " + repeat("приветы",2));
        System.out.println("Задание 2: " + differenceMaxMin(new double[]{3,7,90,5}));
        System.out.println("Задание 3: " + isAvgWhole(new double[]{2,2,2}));

        System.out.println("Задание 4: ");
        int[] arr = new int[] {1,2,3};
        cumulativeSum(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Задание 5: " + getDecimalPlaces("3.14"));
        System.out.println("Задание 6: " + Fibonacci(5));
        System.out.println("Задание 7: " + isValid("73640"));
        System.out.println("Задание 8: " + isStrangePair("Hello", "ohhhH"));
        System.out.println("Задание 9: " + isPrefix("automation", "auto-"));
        System.out.println("Задание 9: " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("Задание 10: " + boxSeq(1));

    }

    // Задание 1
    public static String repeat(String s, int n) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < n; k++) {
                newString += s.charAt(i);
            }
        }
        return newString;
    }

    // Задание 2
    public static double differenceMaxMin(double[] array) {
        Arrays.sort(array);
        double min = array[0];
        double max =array[array.length - 1];
        return max - min;
    }

    // Задание 3
    public static boolean isAvgWhole(double[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum % array.length == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Задание 4
    public static int[] cumulativeSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        return array;
    }

    // Задание 5
    public static int getDecimalPlaces(String s){
        int n = s.length();
        int i = 0;

        for(; i < n && s.charAt(i) != '.'; i++);

        if(i == n)
            return 0;
        else
            return n-i-1;
    }

    // Задание 6
    public static int Fibonacci(int n){
        int[] array = new int[n+1];
        array[0] = array[1] = 1;

        for(int i = 2; i <= n; i++){
            array[i] = array[i-2] + array[i-1];
        }
        return array[n];
    }

    // Задание 7
    public static boolean isValid(String ticket){
        if(ticket.length() != 5)
            return false;
        for(int i = 0; i < ticket.length();i++){
            if(ticket.charAt(i) < '0' || ticket.charAt(i) > '9')
            return false;
        }
        return true;
    }

    // Задание 8
    public static boolean isStrangePair(String s_one, String s_two) {
        if(s_one == "" && s_one == s_two)
            return true;
        else if((s_one == "" && s_two != s_one)  || (s_two == "" && s_two != s_one))
        return false;
        int n1 = s_one.length() - 1;
        int n2 = s_two.length() - 1 ;
        if(s_one.charAt(0) == s_two.charAt(n2) && s_one.charAt(n1) == s_two.charAt(0))
            return true;
        else
            return false;
    }

    // Задание 9
    public static boolean isPrefix(String s, String prefix) {
        String pref = "";
        for(int i = 0; i < prefix.length() - 1; i++)
            pref += prefix.charAt(i);

        int n = 0;
        for(int i = 0; i < pref.length(); i++){
            if(s.charAt(i) == pref.charAt(i))
                n++;
        }
        return n == pref.length();
    }

    // Задание 9
    public static boolean isSuffix(String s, String suffix){
        String suff = "";
        for(int i = 1; i < suffix.length(); i++) {
            suff += suffix.charAt(i);
        }
        int n = 0;
        for(int i = 0; i <= suff.length(); i++){
            if(s.charAt(i + s.length() - suffix.length()) == suffix.charAt(i))
                n++;
        }
        return n == suff.length();
    }

    // Задание 10
    public static int boxSeq(int n) {
        if(n % 2 == 0)
            return n;
        else
            return n + 2;
    }

}
