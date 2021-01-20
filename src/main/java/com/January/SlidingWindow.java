package com.January;

import java.util.HashMap;

public class SlidingWindow {

  //LongestSubstringKDistinct

  public static int findLength(String str, int k) {
	char[] multiChar = str.toCharArray();
	int returnInt = findLengthHelper(multiChar, k);
	return returnInt;
  }

  private static int findLengthHelper(char[] multiChar, int k) {
	int returnVal = 0;
	HashMap<Character, Integer> hm = new HashMap<>();
	int windowEnd = 0;
	int windowStart = 0;
	for (int i = 0; i<multiChar.length && windowEnd < multiChar.length; i++) {
	  while (windowEnd < multiChar.length && hm.size() < k && i < multiChar.length) {
		if (hm.containsKey(multiChar[windowEnd])) {
		  Integer getVal = hm.get(multiChar[windowEnd]);
		  getVal++;
		  hm.put(multiChar[windowEnd], getVal);
		} else {
		  hm.put(multiChar[windowEnd], 1);
		}
		windowEnd++;
	  }
	  //update the distinct char len if len of return string is long
	  if(returnVal < windowEnd-windowStart)
	    returnVal = windowEnd-windowStart;
	  System.out.println("Hashmap range "+hm+" When return value "+returnVal);
	  // move windowstart and update the hashmap
	  if(hm.get(multiChar[windowStart]) == 1)
	    hm.remove(multiChar[windowStart]);
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
	System.out.println("Longest Substring with K Distinct Characters (medium)");
	String inputStr = new String("cbbebi");
	int distinctChar = 3;
	System.out.println("Sliding Window Length "+SlidingWindow.findLength(inputStr, distinctChar));

  }
}
