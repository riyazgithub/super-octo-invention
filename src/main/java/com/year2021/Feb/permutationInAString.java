package com.year2021.Feb;

import java.util.HashMap;
import java.util.Map;

public class permutationInAString {

  /*
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
   */
  public static boolean findPermutation(String str, String pattern) {
    HashMap<Character, Integer> hmPattern = new HashMap<>();
    populateHM(hmPattern, pattern);
    System.out.println("Pattern HM "+hmPattern);
    char[] arrtoChar = str.toCharArray();
    return findPermutationHelper(arrtoChar,hmPattern,pattern);
  }

  private static boolean findPermutationHelper(char[] arrtoChar, HashMap<Character,Integer> hmPattern, String pattern) {
    int windowEnd = 0;
    int windowStart = 0;
    //setting the size of sliding window

    for(int i=0;i<pattern.length();i++) {
      if(hmPattern.containsKey(arrtoChar[i])) {
        updateHMPattern(hmPattern, arrtoChar[i], 0);
      }
      windowEnd++;
    }
    for(int i=windowEnd; i< arrtoChar.length && windowEnd < arrtoChar.length && !checkForParity(hmPattern); i++) {

      if (hmPattern.containsKey(arrtoChar[windowStart]))
    {
      updateHMPattern(hmPattern, arrtoChar[windowStart], 1);
    }
      if (hmPattern.containsKey(arrtoChar[windowEnd]))
      {
        updateHMPattern(hmPattern, arrtoChar[windowEnd], 0);
      }
      windowStart++;
      windowEnd++;
    }
    System.out.println("Window Start "+windowStart+" Window End "+windowEnd);
    System.out.println("Final "+hmPattern);
      return checkForParity(hmPattern);
  }

  private static void updateHMPattern(HashMap<Character,Integer> hmPattern, char c, Integer condition) {

    Integer getVal = hmPattern.get(c);
    if(getVal>0 && condition==0) getVal--;
    else if (condition==1) getVal++;
    hmPattern.put(c,getVal);
  }

  private static boolean checkForParity(HashMap<Character,Integer> hmPattern) {
    int sum =0;
    for(Map.Entry<Character,Integer> me : hmPattern.entrySet())
    {
      sum += me.getValue();
    }
    if(sum == 0) return true;
    return false;
  }

  private static void populateHM(HashMap<Character,Integer> hm, String pattern) {
    hm.clear();
    char[] toChar = pattern.toCharArray();
    for (char c: toChar) {
      if(hm.containsKey(c)) {
        Integer getVal = hm.get(c);
        getVal++;
        hm.put(c, getVal);
      } else
        hm.put(c, 1);
    }
  }

  public static void main(String[] args) {
    String inputStr = "oidbcaf";
    String pattern = "abc";
    System.out.println("Permutation "+findPermutation("oidbcfabef", "abc"));
  }
}
