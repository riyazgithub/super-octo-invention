package com.January;

import java.util.HashMap;

public class NoRepeatSubstring {

  public static int findLength(String str) {
	char[] multiChar = str.toCharArray();
	int returnInt = findLengthHelper(multiChar);
	return returnInt;
  }

  private static int findLengthHelper(char[] multiChar) {
	int returnVal = 0;
	HashMap<Character, Integer> hm = new HashMap<>();
	int windowEnd = 0;
	int windowStart = 0;
	for (int i = 0; i<multiChar.length && windowEnd < multiChar.length ; i++) {
	  while (windowEnd < multiChar.length && i < multiChar.length) {
		if (hm.containsKey(multiChar[windowEnd])) {
		  break;
		} else {
		  hm.put(multiChar[windowEnd], 1);
		  windowEnd++;
		}
	  }
	  //update the distinct char len if len of return string is long
	  if(returnVal < windowEnd-windowStart)
		returnVal = windowEnd-windowStart;
	  System.out.println("Hashmap range "+hm+" When return value "+returnVal);
	  // move windowstart and update the hashmap
	  hm.remove(multiChar[windowStart]);
	  windowStart++;
	  i=windowEnd;
	}
	return returnVal;
  }
  public static void main(String[] args) {

    String str = new String("aabccbb");
	System.out.println("======= String ====== "+str+": "+NoRepeatSubstring.findLength(str));
	str = new String("abbbb");
	System.out.println("======= String ====== "+str+": "+NoRepeatSubstring.findLength(str));
	str = new String("abccde");
	System.out.println("======= String ====== "+str+": "+NoRepeatSubstring.findLength(str));


  }

}
