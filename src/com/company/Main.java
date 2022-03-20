package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(isPrime(6));
//        System.out.println(factorial(8));
//        permutations("donda");
//        System.out.println(isUniqueChars2("omotara"));omotara

//        int[] array = new int[7];

        Set<String> ddd = new HashSet<>();
        ddd.add("ol");
        if(ddd.contains("ol")){
            System.out.println( true);
        }else{
            System.out.println( false);
        }
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        String[] arr = {"olumiide"};
//       Arrays.asList(array).stream().collect(Collectors.toCollection(ArrayList::new));
//       List list = new ArrayList<>(Arrays.asList(arr));
//       Collections.sort(new ArrayList<>(Arrays.asList(arr)));
//        reverseArrayInPlace(array);
//        System.out.println(array);
        for(int i = 0; i < array.length ; i++){
//            System.out.println(array[i]);
            System.out.println(array.length  - i - 1);
//            for(int j = i + 1; j < array.length; j++){
////                System.out.println("This is J " +array[j]);
//            }
            Map<String,Integer> res = new HashMap<>();

        }
    }

    /** Runs O(sqrt(n))**/
    static boolean isPrime(int n){
        for(int x = 2; x * x <= n ; x++){
            System.out.println(x);
            if(n % x == 0)
                return false;
        }
        return true;
    }

    /** Runs O(n)**/
    static int factorial(int n){
        if(n < 0){
            return -1;
        }else if(n == 0){
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }

    public static void reverseArrayInPlace(int[] array){
        int start = 0;
        int end = array.length - 1;

        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    static void permutations(String str){
        permutations(str,"");
    }
    static void permutations(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
        }else{
            for(int i = 0; i < str.length(); i++){
//                System.out.println(str.substring(0,i));
//                System.out.println(str.substring(i + 1));
//                System.out.println(str.charAt(i));
                String rem = str.substring(0,i) + str.substring(i + 1);
                permutations(rem,prefix + str.charAt(i));
            }
        }
    }

    static int fib(int  n){
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        return fib(n- 1) + fib(n - 2);
    }

    /** TRy out Memoization to optimize fibonacci series Runs O(n)**/

    static void allFib(int n){
        int [] memo = new int [n + 1];
        for(int i = 0; i < n; i++){
            System.out.println(i + ":" + fib(i, memo));
        }
    }
    static int  fib(int n, int[] memo){
        if(n <= 0) return 0;
        else if(n == 1) return 1;
        else if(memo[n] > 0) return memo[n];

        memo[n] = fib(n - 1, memo) + fib(n- 2, memo);
        return memo[n];
    }

    /** Guess the sqrt of an integer**/
    static int getSqrt(int n){
        return sqrtHelper(n,1,n);
    }

    static int sqrtHelper(int n, int min, int max){

        int guess = (min + max) / 2;
        if(guess * guess == n) return guess;
        else if(guess * guess < n) return sqrtHelper(n,guess + 1,max);
        else  return sqrtHelper(n,min,guess - 1);

    }

    int [] copyArray(int [] arr){
        int [] copy = new int[0];
        for(int value : arr){
            copy = appendToNew(copy, value);
        }
        return copy;
    }

    int [] appendToNew(int[] copy, int value){
        // copy all elements over to new array
        int [] biggerArray = new int[copy.length + 1];
        for(int i = 0; i < copy.length; i++){
            biggerArray[i] = copy[i];
        }
        biggerArray[biggerArray.length - 1] =  value;

        return biggerArray;
    }

    ArrayList<String> merge(String[] words, String[] more){
        ArrayList<String> sentence = new ArrayList<>();

        for(String w : words) sentence.add(w);
        for(String m : more) sentence.add(m);

        return sentence;
    }

    /*** This wil  give 0(N^2) **/
    String joinWords(String[] words){
        String sentence = "";
        for(String w: words)
            sentence = sentence + w;
        return sentence;
    }

    /*** This wil  give 0(N) **/
    String joinWords2(String[] words){
        StringBuilder sentence = new StringBuilder();
        for(String w: words)
            sentence.append(w);
        return sentence.toString();
    }



}
