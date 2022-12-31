package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        int[] arrayForSecondTask = new  int[]{72, 33, -73, 84, -12, -3, 13, -13, -68};
        String[] arrayForFifthTask = new String[]{"toe", "ocelot", "maniac"};

        System.out.println("Задание 1: " + Arrays.toString(encrypt("Sunshine")));
        System.out.println("Задание 1: " + decrypt(arrayForSecondTask));
        System.out.println("Задание 2: " + canMove("Queen", "C4", "D6"));
        System.out.println("Задание 3: " + canComplete("butl", "beautiful"));
        System.out.println("Задание 4: " + sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println("Задание 5: " + Arrays.toString(sameVowelGroup(arrayForFifthTask)));
        System.out.println("Задание 6: " + validateCard(1234567890123452L));
        System.out.println("Задание 7: " + numToEng(909));
        System.out.println("Задание 8: " + getSha256Hash("password123"));
        System.out.println("Задание 9: " + correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println("Задание 10:\n" + hexLattice(19));
    }

    // ЗАДАНИЕ 1
    public static int[] encrypt(String a) { //код строки: а[0] - код символа, остальные эелементы - различия между символами
        int lSymb = 0;
        int[] ascii = new int[a.length()];
        for (int i=0; i<a.length(); i++) {
            ascii[i] = (int)a.charAt(i) - lSymb;
            lSymb = a.charAt(i);
        }
        return ascii;
    }

    // ЗАДАНИЕ 1
    public static String decrypt(int[] s) { //декодированное сообщение (код - массив)
        char lAscii = 0;
        StringBuilder symbols = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            symbols.append((char)(lAscii + s[i]));
            lAscii = symbols.charAt(i);
        }
        return symbols.toString();
    }

    // ЗАДАНИЕ 2
    public static boolean canMove(String figure, String from, String to) { //проверка хода шахматной фигуры из её положения в целевую позицию
        if (figure.equals("Pawn")) { //пешка
            if (from.charAt(0) == to.charAt(0)) {
                if (from.charAt(1) == '2' && to.charAt(1) == '4') return true;
                if (from.charAt(1) == '5' && to.charAt(1) == '7') return true;
                if (Math.abs((int)from.charAt(1) - (int)to.charAt(1)) == 1) return true;
            }
        }
        if (figure.equals("Horse")) { //конь
            if (Math.abs((int)from.charAt(0) - (int)to.charAt(0)) == 2
                    && Math.abs((int)from.charAt(1) - (int)to.charAt(1)) == 1)
                return true;

            if (Math.abs((int)from.charAt(1) - (int)to.charAt(1)) == 2
                    && Math.abs((int)from.charAt(0) - (int)to.charAt(0)) == 1)
                return true;
        }
        if (figure.equals("Bishop")) { //слон
            if (Math.abs((int)from.charAt(0) - (int)to.charAt(0)) == Math.abs((int)from.charAt(1) - (int)to.charAt(1)))
                return true;
        }
        if (figure.equals("Rook")) { //ладья
            if (from.charAt(0) == to.charAt(0) || from.charAt(1) == to.charAt(1))
                return true;
        }
        if (figure.equals("Queen")) { //ферзь
            if (Math.abs((int)from.charAt(0) - (int)to.charAt(0)) == Math.abs((int)from.charAt(1) - (int)to.charAt(1)))
                return true;
            if (from.charAt(0) == to.charAt(0) || from.charAt(1) == to.charAt(1))
                return true;
        }
        if (figure.equals("King")) { //король
            if (Math.abs((int)from.charAt(0) - (int)to.charAt(0)) <= 1
                    && Math.abs((int)from.charAt(1) - (int)to.charAt(1)) <= 1)
                return true;
        }
        return false;
    }

    // ЗАДАНИЕ 3
    public static boolean canComplete(String a, String b) { //проверка, может ли слово а превратиться в b
        int n = 0;
        for (int i=0; i<b.length(); i++) {
            if (a.charAt(n) == b.charAt(i)) n++;
        }
        if (n == a.length()) return true;
        else return false;
    }

    // ЗАДАНИЕ 4
    public static int sumDigProd(int... a) { //сложение чисел -> произведение их цифр, пока ответ != одной цифре
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        while (sum >= 10) {
            sum = multiply(sum);
        }
        return (sum);
    }

    public static int multiply(int a) { //произведение цифр числа
        int m = 1;
        while (a > 0) {
            m *= a%10;
            a /= 10;
        }
        return m;
    }

    // ЗАДАНИЕ 5
    public static String[] sameVowelGroup(String[] words) { //выбор слов с такими же гласными, что и в первом слове
        Set<Character> vow1 = new HashSet<>();
        String word1 = words[0].replaceAll("[qwrtpsdfghjklzxcvbnm]", "");
        for (char charIn1 : word1.toCharArray()) {
            vow1.add(charIn1);
        }
        ArrayList<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i=1; i<words.length; i++) {
            Set<Character> vowCur = new HashSet<>();
            String wordCur = words[i].replaceAll("[qwrtpsdfghjklzxcvbnm]", "");
            for (char charInCur : wordCur.toCharArray()) {
                vowCur.add(charInCur);
            }
            if (vow1.equals(vowCur)) res.add(words[i]);
        }
        return res.toArray(new String[]{});
    }

    // ЗАДАНИЕ 6
    public static boolean validateCard(Long a) { //проверка на действительный номер кредитной карты
        if (a<Math.pow(10, 14) || a>=Math.pow(10, 20)) return false;
        int checkDigit = (int)(a % 10);
        String num = String.valueOf(a/10);
        int sum = 0;
        for (int i=num.length()-1; i>=0; i--) {
            int doubleInt = (int)num.charAt(i);
            if ((num.length() - i) % 2 != 0) {
                doubleInt *= 2;
                if (doubleInt > 9) doubleInt = doubleInt / 10 + doubleInt % 10;
            }
            sum += doubleInt;
        }
        return (10 - (sum%10)) == checkDigit;
    }

    // ЗАДАНИЕ 7
    public static String numToEng(int num) { //строковое представление натурального числа < 1000
        String[] ones = {"zero","one","two","three","four","five","six","seven",
                "eight","nine"}; //единицы
        String[] tens1 = {"ten","eleven","twelve","thirteen","fourteen","fifteen",
                "sixteen","seventeen","eighteen","nineteen"}; //числа 10-19
        String[] tens2 = {"","twenty","thirty","forty","fifty","sixty","seventy","eighty",
                "ninety"}; //десятки
        String strNum = Integer.toString(num);

        switch (strNum.length()) {
            case 1: //для чисел 0-9
                return ones[num];
            case 2: //для чисел 10-99
                if (num >= 10 && num <= 19) return tens1[num - 10];
                else return tens2[num/10 - 1] + " " + ones[num%10];
            case 3: //для чисел 100-999
                StringBuilder res = new StringBuilder(ones[num/100] + " hundred ");
                strNum = strNum.substring(1);
                if (strNum.charAt(0) == '0') {
                    strNum = strNum.substring(1);
                    res.append(ones[Integer.parseInt(strNum)%10]);
                }
                else {
                    if (Integer.parseInt(strNum) >= 10 && Integer.parseInt(strNum) <= 19) res.append(tens1[Integer.parseInt(strNum) - 10]);
                    else res.append(tens2[Integer.parseInt(strNum)/10 - 1] + " " + ones[Integer.parseInt(strNum)%10]);
                }
                return res.toString();
            default:
                break;
        }
        return "";
    }

    // ЗАДАНИЕ 8
    public static String getSha256Hash(String str) { //хеш SHA-256 для данной строки
        StringBuilder res = new StringBuilder();
        try {
            //шифр байтов в строку
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(str.getBytes());
            //перевод их в хеш
            for (int i = 0; i < hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) res.append(0);
                res.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    // ЗАДАНИЕ 9
    public static String correctTitle(String str) { //все слова с большой буквы, кроме служебных
        String s = str.toLowerCase();
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word: words) {
            if (!word.equals("of") && !word.equals("in") && !word.equals("and") && !word.equals("the"))
                res.append(word.substring(0,1).toUpperCase() + word.substring(1) + " ");
            else {
                res.append(word.toLowerCase() + " ");
            }
        }
        return res.toString();
    }

    // ЗАДАНИЕ 10
    public static String hexLattice(int n) { //вывод на экран гексагональной решетки для центрированного шестиугольного числа
        int i = 0; //номер центрированного числа по порядку (0,1,2...)
        boolean isHexNum = false;
        while (3*i*(i+1)+1 <= n){
            if (3*i*(i+1)+1 == n) isHexNum = true;
            i++;
        }
        StringBuilder res = new StringBuilder();
        if (isHexNum){
            int l = i; //для 'o'
            int m = i; //для пробелов
            for (int j = 0; j < 2*i-1; j++){
                res.append("\n");
                StringBuilder space = new StringBuilder("");
                for (int k = 1; k < m; k++){
                    space.append(" ");
                }
                res.append(space);
                for (int k = 0; k < l; k++){
                    res.append(" o");
                }
                res.append(space + " ");
                l += (j < i-1) ? 1 : -1;
                m += (j < i-1) ? -1 : 1;
            }
            return res.toString().replaceFirst("\n", "");
        } else return "Invalid";
    }
}