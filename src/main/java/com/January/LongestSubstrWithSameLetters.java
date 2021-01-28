package com.January;

public class LongestSubstrWithSameLetters {

  /**
   * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
   * find the length of the longest substring having the same letters after replacement.
   */

  public static void main(String[] args) {
	String str = new String("aabccbb");
	System.out.println(SlidingWindow.findLength(str,2));
	str = new String("abbcb");
	System.out.println(SlidingWindow.findLength(str,2));
	str = new String("abccde");
	System.out.println(SlidingWindow.findLength(str,2));

  }
}
