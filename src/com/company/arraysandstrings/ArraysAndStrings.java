package com.company.arraysandstrings;

import java.util.Arrays;

public class ArraysAndStrings {

    /**
     * Given two strings,write a method to decide if one is a permutation of the
     * other. Not really optimized
     * **/
    static boolean checkForPermutation(String a, String b){
        //first of all sort
        if(a.length() != b.length()) return false;
        return sort(a).equals(sort(b));


    }

    static boolean checkForPermutation2(String a, String b){
        //try to convert a string to char
        if(a.length() != b.length()) return false; // check if they have the same length

        int [] letters = new int [128]; //assume  its ASCII
        char[] sArray = a.toCharArray();
        for(char s : sArray)
            letters[s]++;
        System.out.println(Arrays.toString(letters));
        for(int i = 0; i < b.length(); i++){
            int c = b.charAt(i);
            letters[c]--;
            System.out.println(Arrays.toString(letters));
            if(letters[c] < 0) return false;
        }

        return true;

    }

    static String sort(String str){
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /**
     * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
     * ***/
    static boolean isUniqueChars(String characters){
        if(characters.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < characters.length(); i++){
            int val = characters.charAt(i);
            System.out.println(val);
            if(char_set[val]){
                //character already exist
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
     * Optimized version
     * */
    static boolean isUniqueChars2(String str){
        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    static String replaceSpaces(String str, int trueLength){
        char [] charStr = str.toCharArray();
        System.out.println(Arrays.toString(charStr));
        //count the space first
        int spaceCount = 0;
        int index, i = 0;
        for( i = 0; i < trueLength; i++){
            if(charStr[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if(trueLength < charStr.length) charStr[trueLength] = '\0';
        for(i = trueLength - 1; i >= 0; i-- ){
            if(charStr[i] == ' '){
                charStr[index - 1] = '0';
                charStr[index - 2] = '2';
                charStr[index -  3] = '%';
                index = index - 3;
            }else{
                charStr[index - 1] = charStr[i];
                index--;
            }
        }
        return Arrays.toString(charStr);
    }

    static boolean isPalindrome(String phase){
        int[] table = buildCharFrequency(phase);
        return checkOneMaxOdd(table);
    }

    /* Check that no more than one character has an odd count. */

    static boolean checkOneMaxOdd(int[] table){
        boolean foundOdd = false;
        for(int count : table){
            if(foundOdd) return false;

            foundOdd = true;
        }
        return true;
    }

    /** Map each character to a number. a -> 0, b -> 1, c -> 2, etc. 21 *
    This is case insensitive. Non-letter characters map to -1. */
    static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z){
            return val - a;
        }
        return -1;
    }
    static int [] buildCharFrequency(String phrase){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }

        return table;
    }

    /**
     * There are three types of edits that can be performed on
     * strings: insert a character, remove a character,
     * or replace a character. Given two strings,
     * write a function to check if they are one edit (or zero edits) away.
     * **/
    static boolean oneAway(String a, String b){
        //length checks
        if(a.length() > b.length())
            return false;
        //Get shorter and longer strZA
        String s1 = a.length() < b.length() ? a : b;
        String s2 = a.length() < b.length() ? b : a;
        int index = 0;
        int index2 = 0;

        boolean foundDiff = false;
        while(index2 < s2.length() && index < s1.length()){
            if(s1.charAt(index) != s2.charAt(index2)){
                if(foundDiff) return false;
                foundDiff = true;
                if(s1.length() == s2.length()){
                    //On replace, move shorter pointer
                    index++;
                }
            }else{
                //move  pointer for shorter string if matching
                index++;
            }
            //move  pointer for longer string
            index2++;
        }
        return true;
    }

    /**
     * Implement a method to perform basic
     * string compression using the counts of repeated characters.
     * **/
    static String compression(String str){
        StringBuilder compressed = new StringBuilder();
        int consecutiveCount = 0;
        for(int i = 0; i < str.length(); i++){
            consecutiveCount++;
            /* If next character is different than current,
             append this char to result.*/
            if((i + 1 >= str.length()) || str.charAt(i) != str.charAt(i + 1)){
                compressed.append(str.charAt(i));
                compressed.append(consecutiveCount);
                consecutiveCount = 0;
            }

        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }


    public static void main(String[] args) {
//        System.out.println(sort("olumide"));
//        System.out.println(checkForPermutation2("god","dog"));
        System.out.println(replaceSpaces("Mr John Smith ", 13));
//        System.out.println(replaceSpaces());
    }
}