package com.Mar;

import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
	List<List<Integer>> triplets = new ArrayList<>();
	// TODO: Write your code here
	return triplets;
  }

  public static int[] getTargetSum(int[] arr, int targetSum, int pointOne) {
	int[] targetIndices = new int[] { -999, -999 };
	int windowStart =0, windowEnd = arr.length-1;
	while((targetSum != arr[windowEnd]+arr[windowStart]) && windowStart < windowEnd) {
	  if(arr[windowEnd]+arr[windowStart] > targetSum) {
		windowEnd--;
		if(arr[windowEnd] == arr[windowEnd-1])
		  windowEnd--;
	  } else {
	    windowStart++;
		if(arr[windowStart] == arr[windowStart+1])
		  windowStart++;
	  }
	}
	if((targetSum == arr[windowEnd]+arr[windowStart])) {
	  targetIndices[0] = windowStart;
	  targetIndices[1] = windowEnd;
	}

	return targetIndices;
  }

}