package com.January;

import java.util.HashMap;

public class SlidingWindow {

  //LongestSubstringKDistinct

  public static int findLength(String str, int k) {
	char[] multiChar = str.toCharArray();
	int returnInt = findLengthHelper(multiChar, 2);
	System.out.println("Return Int "+ returnInt +" For "+str);
	return returnInt;
  }

  private static int findLengthHelper(char[] multiChar, int k) {
	int returnVal = 0;
	HashMap<Character, Integer> hm = new HashMap<>();
	int windowEnd = 0;
	int windowStart = 0;
	for (int i = 0; i<multiChar.length && windowEnd < multiChar.length && hm.size() <= k; i++) {
	  while (windowEnd < multiChar.length && i < multiChar.length) {
		if (hm.containsKey(multiChar[windowEnd])) {
		  Integer getVal = hm.get(multiChar[windowEnd]);
		  getVal++;
		  hm.put(multiChar[windowEnd], getVal);
		  windowEnd++;
		} else if(hm.size() < k ){
		  hm.put(multiChar[windowEnd], 1);
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
	String inputStr = new String("araaci");
	int distinctChar = 2;
	System.out.println("Sliding Window Length "+SlidingWindow.findLength(inputStr, distinctChar));
	inputStr = new String("cbbebi");
	distinctChar = 3;
	System.out.println("Sliding Window Length "+SlidingWindow.findLength(inputStr, distinctChar));
	inputStr = new String("aa");
	distinctChar = 1;
	System.out.println("Sliding Window Length "+SlidingWindow.findLength(inputStr, distinctChar));

  }
}
