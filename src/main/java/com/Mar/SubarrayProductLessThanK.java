package com.Mar;
import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> arrays = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            List<Integer> subArray = new ArrayList<>();
            Integer product = arr[i];
            int currentPos = i+1;
            if(arr[i] < target)
            {
                subArray.add(arr[i]);
                arrays.add(new ArrayList<>(subArray.subList(0,subArray.size())));
            }
            else
                continue;
            while (product < target && currentPos < arr.length) {
                if(product*arr[currentPos] < target){
                    subArray.add(arr[currentPos]);
                    arrays.add(new ArrayList<>(subArray.subList(0,subArray.size())));
                    product = product*arr[currentPos];
                }
                currentPos++;
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = findSubarrays(new int[] { 2, 5, 3, 10 }, 30);
        System.out.println(arrays);
        System.out.println("Size "+arrays.size());
        arrays = findSubarrays(new int[] { 8, 2, 6, 5 }, 50);
        System.out.println(arrays);
        System.out.println("Size "+arrays.size());
    }
}