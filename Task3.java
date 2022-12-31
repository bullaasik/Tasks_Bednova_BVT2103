package com.company;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Задание 1: " + solutions(1, 0, -1));
        System.out.println("Задание 2: " + findZip("all zip files are zipped"));
        System.out.println("Задание 3: " + checkPerfect(6));
        System.out.println("Задание 4: " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("Задание 5: " + isValidHexCode("#CD5C5C"));
        System.out.println("Задание 6: " + same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("Задание 7: " + isKaprekar(3));
        System.out.println("Задание 8: " + longestZero("01100001011000"));
        System.out.println("Задание 9: " + nextPrime(12));
        System.out.println("Задание 10: " + rightTriangle(3, 4, 5));
    }

    // Задание 1
    public static int solutions(int a, int b, int c) {
        int D = b * b - 4 * a * c;
        if (D > 0) return 2;
        else if (D == 0) return 1;
        else return 0;
    }

    // Задание 2
    public static int findZip(String s) {
        int n = 0;
        int index = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            while (n < 2) {
                if ((s.charAt(i) == 'z' || s.charAt(i) == 'Z') && (s.charAt(i + 1) == 'i' || s.charAt(i + 1) == 'I') &&
                (s.charAt(i + 2) == 'p' || s.charAt(i + 2) == 'P')){
                    n++;
                    index = i;
                }
                break;
            }
        }
        if (n == 2)
            return index;
        else
            return -1;
    }

    // Задание 3
    public static boolean checkPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0)
                sum += i;
        }
        return sum == n;
    }

    // Задание 4
    public static String flipEndChars(String s) {
        if (s.length() < 2)
            return "Incompatible.";
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return "Two's a pair.";
        else
            return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
    }

    // Задание 5
    public static boolean isValidHexCode(String s) {
        int flag = 0;
        if (s.length() == 7 && s.charAt(0) == '#') {
            for (int i = 1; i < s.length(); i++) {
                if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') ||
                (s.charAt(i) >= 'a' && s.charAt(i) <= 'f'))
                flag = 1;
            }
        }
        return flag == 1;
    }

    // Задание 6
    public static boolean same(int[] arr1, int[] arr2) {

        return count_unique(arr1) == count_unique(arr2);
    }

    private static int count_unique(int[] arr) {

        Map<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        return map.size();

    }

    // Задание 7
    public static boolean isKaprekar(int n) {
        if (n == 0  || n == 1)return true;
        if (n < 0) return false;
        int nn = n * n;
        int len = String.valueOf(nn).length();

        if (len % 2 == 0) {
            int l = nn / (int) Math.pow(10, len / 2);
            int r = nn % (int) Math.pow(10, len / 2);
            return r + l == n;
        } else {
            int l = nn / (int) Math.pow(10, len / 2 + 1);
            int r = nn % (int) Math.pow(10, len / 2 + 1);
            return r + l == n;
        }
    }

    // Задание 8
    public static String longestZero(String s) {
        String n = "";
        String mx = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                n += s.charAt(i);
            else {
                if (n.length() > mx.length()) {
                    mx = n;
                    n = "";
                } else n = "";
            }
        }
        return mx;
    }

    // Задание 9
    public static int nextPrime(int n) {
        if (isPrime(n)) return n;
        else {
            while (!isPrime(n))
                n++;
            return n;
        }
    }

    private static boolean isPrime(int n) {
        if (n == 0  || n == 1)return false;
        if (n == 2) return true;
        int flag = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) flag++;
        }
        return flag == 0;
    }

    // Задание 10
    public static boolean rightTriangle(int x, int y, int z) {
        if (x + y > z && x + z > y && y + z > x)
            return x * x == y * y + z * z || y * y == x * x + z * z || z * z == x * x + y * y;
        return false;
    }
}
