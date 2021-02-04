package com.Feb;

import java.util.HashMap;

public class LongestSubarraywithOnes {

  public static int findLength(int[] arr, int k) {

    int output = LongestSubarraywithOnes.findLengthHelper(arr,k,1);
	return output;
  }

  private static int findLengthHelper(int[] multiChar, int k, int ignore) {
	int returnVal = 0;
	HashMap<Integer, Integer> hm = new HashMap<>();
	int windowEnd = 0;
	int windowStart = 0;
	// initializing hasmap
	hm.put(1,0);hm.put(0,0);
	for (int i = 0; i<multiChar.length && windowEnd < multiChar.length && hm.get(1) <= k; i++) {
	  while (windowEnd < multiChar.length && i < multiChar.length) {
		if (hm.containsKey(multiChar[windowEnd])) {
		  Integer getVal = hm.get(multiChar[windowEnd]);
		  getVal++;
		  hm.put(multiChar[windowEnd], getVal);
		  windowEnd++;
		}
		else
		  break;
	  }
	  //update the distinct char len if len of return string is long
	  if(returnVal < windowEnd-windowStart)
		returnVal = windowEnd-windowStart;
	  System.out.println("Hashmap range "+hm+" When return value "+returnVal);
	  // move windowstart and update the hashmap
	  if(hm.get(multiChar[windowStart]) == 1)
		hm.put(multiChar[windowStart],0);
	  else
	  {
		int val = hm.get(multiChar[windowStart]);
		val--;
		hm.put(multiChar[windowStart], val);
	  }
	  windowStart++;
	  i=windowEnd;
	}
	return returnVal;
  }

  public static void main(String[] args) {

    int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
	System.out.println("For input 2 output is "+LongestSubarraywithOnes.findLength(arr,2));
	int[] arr1 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
	System.out.println("For input 2 output is "+LongestSubarraywithOnes.findLength(arr1,3));


  }
}
