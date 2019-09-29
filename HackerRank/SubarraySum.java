package com.twister.HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrCount = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<arrCount; i++){
            arr.add(sc.nextInt());
        }

        System.out.println(Result.subarraySum(arr));
        sc.close();
    }

    private static class Result {

        /*
         * Complete the 'subarraySum' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */
        private static long getSum(List<Integer> arr, int index, long sum){
            if(index == arr.size())
                return 0;
            sum += arr.get(index);
            return sum + getSum(arr, index+1, sum);
        }
        private static long getSum(List<Integer> arr, int index){
            return getSum(arr, index, 0);
        }
        static long subarraySum(List<Integer> arr){
            long sum = 0 ;
            for(int i=0; i<arr.size(); i++){
                sum += getSum(arr, i);
            }
            return sum;
        }
    }
}
