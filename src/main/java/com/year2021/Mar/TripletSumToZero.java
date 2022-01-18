package com.year2021.Mar;

import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
	List<List<Integer>> triplets = new ArrayList<>();
	for(int i =0; i<arr.length-1; i++) {
	  int[] indexes = getTargetSum(arr, arr[i]*-1, arr[i],i);
	  System.out.println("For "+arr[i]+" Index Value "+Arrays.toString(indexes));
	  List<Integer> entry = new ArrayList<>();
	  if(indexes[0]!=-999)
	  {
	    entry.add(arr[i]);
	    entry.add(arr[indexes[0]]);
		entry.add(arr[indexes[1	]]);
		triplets.add(entry);
	  }
	  if(i<arr.length-1 && arr[i] == arr[i+1])
		i++;
	}
	return triplets;
  }

  public static int[] getTargetSum(int[] arr, int targetSum, int pointOne, int start) {
	int[] targetIndices = new int[] { -999, -999 };
	int windowStart =start+1, windowEnd = arr.length-1;
	while((targetSum != arr[windowEnd]+arr[windowStart]) && windowStart < windowEnd) {
	  if(arr[windowEnd]+arr[windowStart] > targetSum) {
		windowEnd--;
		if(arr[windowEnd] == arr[windowEnd-1] && windowEnd >0 )
		  windowEnd--;
	  } else {
	    windowStart++;
		if(windowStart < arr.length-1 && arr[windowStart] == arr[windowStart+1])
		  windowStart++;
	  }
	  if(arr[windowEnd] == pointOne) windowEnd --;
	  else if(arr[windowStart] == pointOne) windowStart++;
	}
	if((targetSum == arr[windowEnd]+arr[windowStart])) {
	  targetIndices[0] = windowStart;
	  targetIndices[1] = windowEnd;
	}

	return targetIndices;
  }

  public static void main(String[] args) {
	int[] inputArr = new int[] {-3, 0, 1, 2, -1, 1, -2};
	int[] indices;
	 // sorting an array
	Arrays.sort(inputArr);
	System.out.println("Input Array "+Arrays.toString(inputArr));
	System.out.println("Triplet "+searchTriplets(inputArr));
//	indices = getTargetSum(inputArr,0,2);
//	System.out.println("Index: "+Arrays.toString(indices));
  }
}