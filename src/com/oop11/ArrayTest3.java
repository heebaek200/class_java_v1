package com.oop11;

public class ArrayTest3 {

    public static void main(String[] args) {

        final int MAX_ALPHA = 26;

        char[] alphabets = new char[MAX_ALPHA];

        char standardChar = 'A';
        for (int i = 0 ; i < alphabets.length ; i++) {
            alphabets[i] = (char)('A' + i);

            System.out.println(alphabets[i]);
        }



    }

}
