package com.year2020.December;

public class SlidingWindow {
 public static double[] findAverages(int K, int[] arr) {
	double[] result = new double[arr.length - K + 1];
	double windowSum = 0;
	int windowStart = 0;
	for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
	  windowSum += arr[windowEnd]; // add the next element
	  // slide the window, we don't need to slide if we've not hit the required window size of 'k'
	  if (windowEnd >= K - 1) {
		result[windowStart] = windowSum / K; // calculate the average
		windowSum -= arr[windowStart]; // subtract the element going out
		windowStart++; // slide the window ahead
	  }
	}

	return result;
  }
  public static int findMaxSumSubArray(int k, int[] arr) {
	int findMaxSum = 0;
	int windowSum = 0;
	int windowStart = 0;
	for(int windowend =0; windowend < arr.length; windowend++) {
	  windowSum += arr[windowend];
	  if(windowend >= k-1) {
	    if(windowSum > findMaxSum) findMaxSum = windowSum ;
		windowSum -= arr[windowStart];
		windowStart++;
	  }
	}

	return findMaxSum;
  }

  public static int findMinSubArray(int S, int[] arr) {
   int sizeOfSubArray = 0;
   for(int k=1; k<= arr.length; k++) {
     int[] smallArr = new int[k];
     int windowSum = 0;
     int windowStart =0;
	 for(int windowend =0; windowend < arr.length; windowend++) {
	   windowSum += arr[windowend];
	   if(windowend >= k-1) {
	     if(windowSum>= S)
	       return k;
		 windowSum -= arr[windowStart];
		 windowStart++;
	   }
	 }

   }
   return sizeOfSubArray;

  }
  public static void main(String[] args) {
//	double[] result = SlidingWindow.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
//	System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
//	int resultInt = SlidingWindow.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
//	System.out.println("Subarray with maximum sum is " + resultInt);
	int resultInt = SlidingWindow.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
	System.out.println("The smallest subarray with a sum great than or equal to " + resultInt);
	resultInt = SlidingWindow.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
	System.out.println("The smallest subarray with a sum great than or equal to " + resultInt);
	resultInt = SlidingWindow.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
	System.out.println("The smallest subarray with a sum great than or equal to " + resultInt);
  }
}