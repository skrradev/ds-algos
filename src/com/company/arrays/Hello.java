package com.company.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hello {

//
//    Напишите функцию, которая возвращает true, если a + b = c, false в противоположном случае.
//
//    Допустимая погрешность – 0.0001
//
//    В упражнении можно использовать пакет Math, импортировать его не надо.
//
//            Ограничения
//    a + b входит в ограничения типа double
//    c входит в ограничения типа double


//    Sample Input:
//
//            0.1 0.2 0.3
//    Sample Output:
//
//            true


    public static double calcDeposit(int month, int interestRate, int balance) {

        double result = balance;
        for (int i = 1; i <= month; i++) {
            double interest = result * interestRate / 100;
            result = result + interest;
        }
        return result;

    }

    static class Patient {
        private String firstName;
        private String lastName;
        private String iin;
        private int age;
        private int weight;
        private int height;
//        public Patient(String firstName,String lastName,  String iin, int age, int weight, int height){
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.iin = iin;
//            this.age = age;
//            this.weight = weight;
//            this.height = height;
//        }


        public Patient(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public String getFirstName(){
            return this.firstName;
        }
        public String getLastName(){
            return this.lastName;
        }
        public String getIIN(){
            return this.iin;
        }
        public int getAge(){
            return this.age;
        }
        public int getWeight(){
            return this.weight;
        }
        public int getHeight(){
            return this.height;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        public void setLastName(String lastName){
            this.lastName = lastName;
        }
        public void setIIN(String iin){
            this.iin = iin;
        }
        public void setAge(int age){
            this.age = age;
        }
        public void setWeight(int weight){
            this.weight=weight;
        }
        public void setHeight(int height){
            this.height=height;
        }



        public double getBMI() {
            //Формула подсчета: ИМТ = (вес в кг) / (рост в метрах) ^ 2

            double wt = weight;
            double ht = height;

            double index = wt / Math.pow(wt, 2);

            return index;


        }
    }


    public static void main(String args[]) {
      int[] arr = {56, 59, 17, 59, 56, 56};
        int[] duplicates = findDuplicates(arr);
        System.out.println("duplicates = " + Arrays.toString(duplicates));


    }

    public static HashMap<String, String> searchPhonebook(HashMap<String, String> phonebook, String value) {
        HashMap<String, String> map = new HashMap<>();

        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            if (entry.getKey().equals(value) || entry.getKey().contains(value)) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public static int[] findUniques(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count+1);
            }
        }

        int size = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                size++;
            }
        }

        int[] unique = new int[size];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                unique[i++] = entry.getKey();
            }
        }

        return unique;
    }

    public static int[] findDuplicates(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count+1);
            }
        }

        int size = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                size++;
            }
        }

        int[] noDupl = new int[size];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                noDupl[i++] = entry.getKey();
            }
        }

        return noDupl;
    }

    public static HashMap<String, Integer> familyMembersCount(String[] people) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String person : people) {
            String[] names = person.split(" ");
            String lastName = names[1];

            if (lastName.endsWith("ва")) {
               lastName = lastName.substring(0, lastName.length()-1);
            }

            Integer count = map.get(lastName);
            if (count == null) {
                map.put(lastName, 1);
            } else {
                map.put(lastName, count+1);
            }

        }
        return map;
    }

    public static void reverse(HashMap<String, String> map) {
        HashMap<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            tempMap.put(entry.getValue(), entry.getKey());
        }

        map.clear();

        for (Map.Entry<String, String> entry : tempMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }


    }


    public static void removeKeys(HashMap<String, String> map, String[] keys) {

        for (String key : keys) {
            map.remove(key);
        }

    }


    public static void driveTaxi(Taxi driver, int toX, int toY) {
        if(toX > driver.getX()) {
            while (driver.getX() != toX) {
                driver.moveRight();
            }
        } else {
            while (driver.getX() != toX) {
                driver.moveLeft();
            }
        }

        if(toY > driver.getY()) {
            while (driver.getY() != toY) {
                driver.moveUp();
            }
        } else {
            while (driver.getY() != toY) {
                driver.moveDown();
            }
        }
    }

    public static class Taxi {
        private int x;
        private int y;

        @Override
        public String toString() {
            return "Taxi{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public void moveRight() {
            x++;
        }
        public void moveLeft(){
            x--;
        }
        public void moveUp(){
            y++;
        }
        public void moveDown(){
            y--;
        }

        public int getX() {
            return x;
        };
        public int getY(){
            return y;
        };
    }

    public static boolean isCapitalized(char[] str) {
        for (int i = 0; i < str.length; i++) {
            if (i == 0) {
                if (Character.isLowerCase(str[i]) || !Character.isLetter(str[i])) return false;
            } else if (Character.isWhitespace(str[i-1]) && (Character.isLowerCase(str[i]) || !Character.isLetter(str[i]))) {
                return false;
            }
        }
        return true;
    }



    public static char[][] split(char[] str) {
        int size = 0;
        for (int i = 0; i < str.length; i++) {
            if (isWhiteSpace(str[i]) && i < str.length - 1) {
                size++;
            }
        }
        size++;

        char[][] array = new char[size][];
        int arrayIter = 0;
        int beforeWhSp = 0;

        for (int i = 0; i < str.length; i++) {
            if (isWhiteSpace(str[i]) || i == str.length - 1) {
                int subArraySize = i == str.length - 1 ? beforeWhSp + 1 : beforeWhSp;
                array[arrayIter] = new char[subArraySize];
                System.arraycopy(str, i - beforeWhSp, array[arrayIter], 0, subArraySize);
                arrayIter++;
                beforeWhSp = 0;
            } else {
                beforeWhSp++;
            }
        }

//        for(int i = 0; i < array.length; i++)
//        {
//            if (array[i] == null) {
//                array[i] = new char[] {'h'};
//            }
//        }

        return array;
    }


    public static boolean isWhiteSpace(char ch) {
        return Character.isWhitespace(ch);
    }






//    public static void capitalize(char[] str) {
//        for (int i = 0; i < str.length; i++) {
//            if (i == 0) {
//                str[i] = isLower(str[i]) ? toUpper(str[i]) : str[i];
//            } else if (str[i - 1] == ' ') {
//                str[i] = isLower(str[i]) ? toUpper(str[i]) : str[i];
//            } else {
//                str[i] = isCapital(str[i]) ? toLower(str[i]) : str[i];
//            }
//        }
//    }

    public static char toUpper(char ch) {
        return (char) (ch - 32);
    }

    public static char toLower(char ch) {
        return (char) (ch + 32);
    }

    public static boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }



    public static boolean startsWith(char[] str1, char[] with1) {
        for (int i = 0; i < with1.length; i++) {
            if (str1[i] != with1[i])
                return false;
        }
        return true;
    }


    public static int compareTo(char[] str1, char[] str2) {
        if (str1 == str2)
            return 0;
        if (str1 == null || str2 == null)
            return str1 == null ? -1 : 1;

        for (int i = 0; i < str1.length; i++) {
            if (str1[i] < str2[i]) {
                return -1;
            } else if (str1[i] > str2[i]) {
                return 1;
            }
        }

        return 0;
    }


    public static String hashPass(String password) {
        int code = password.hashCode();
        String hashed = Integer.toString(code);
        return hashed;
    }

    public static String allowedChars = "0123456789";

    public static String bruteforcePass(String hashedPass) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String pass = String.valueOf(i);
            String s = hashPass(pass);
            if (s.equals(hashedPass)) {
                return pass;
            }
        }
        return "0";
    }

    private static void recursiveReversePrint(char[] str, int k) {
        if (k == 0) {
            return;
        }

        System.out.print(str[k - 1]);
        char[] subArray = new char[str.length - 1];
        System.arraycopy(str, 0, subArray, 0, subArray.length);

        recursiveReversePrint(subArray, subArray.length);
    }
}
