package com.Mar;

import java.util.Arrays;

public class TripletWithSmallSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1; i++) {
            int left = i+1, right = arr.length-1;
            while(left < right) {
                int targetDiff = target - (arr[i]+arr[left] + arr[right]);
                if(targetDiff > 0)
                {
                    count = count + (right - left);
                    System.out.println(arr[i]+" , "+arr[left]+" , "+arr[right]);
                    left++;
                }
                else
                    right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -1, 0, 3, 2 }, 3));
        System.out.println(searchTriplets(new int[] { 4, -1, 1, 2, 3 }, 5));
        System.out.println(searchTriplets(new int[] { 1, 0, 1, 1 }, 100));

    }
}


