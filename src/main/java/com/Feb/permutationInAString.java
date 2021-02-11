package com.Feb;

import java.util.HashMap;

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
    return false;
  }

  private static void populateHM(HashMap<Character,Integer> hm, String pattern) {
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
    String pattern = "abca";
    System.out.println("Permutation "+findPermutation(inputStr, pattern));
  }
}
