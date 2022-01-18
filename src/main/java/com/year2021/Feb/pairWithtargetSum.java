package com.year2021.Feb;

public class pairWithtargetSum {


  public static int[] search(int[] arr, int targetSum) {
	int[] targetIndices = new int[] { -1, -1 };
	int windowStart =0, windowEnd = arr.length-1;
	while((targetSum != arr[windowEnd]+arr[windowStart]) && windowStart < windowEnd) {
	  if(arr[windowEnd]+arr[windowStart] > targetSum) {
	    windowEnd--;
	  } else windowStart++;
	}
	if((targetSum == arr[windowEnd]+arr[windowStart])) {
	  targetIndices[0] = windowStart;
	  targetIndices[1] = windowEnd;
	}

	return targetIndices;
  }

  public static void main(String[] args) {
	int[] targetIndices = pairWithtargetSum.search(new int[] { 1,2,3,4,5,6 }, 6);
	System.out.println("Result index "+targetIndices[0]+" "+targetIndices[1]);
	targetIndices = pairWithtargetSum.search(new int[] { 2,5,9,11 }, 11);
	System.out.println("Result index "+targetIndices[0]+" "+targetIndices[1]);
  }

}
