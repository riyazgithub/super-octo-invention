package com.Feb;

import java.util.HashMap;

public class permutationInAString {

  public static boolean findPermutation(String str, String pattern) {
    HashMap<Character, Integer> hm = new HashMap<>();
    populateHM(hm, pattern);
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
    String pattern = "abc";
    System.out.println("Permutation "+findPermutation(inputStr, pattern));
  }
}
