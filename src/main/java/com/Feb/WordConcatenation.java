package com.Feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
	List<Integer> resultIndices = new ArrayList<Integer>();
	HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
	Integer matches = populateHM(characterIntegerHashMap,words);
	populateIndices(str,characterIntegerHashMap, resultIndices);
	return resultIndices;
  }

  private static void populateIndices(String str, HashMap<Character,Integer> characterIntegerHashMap, List<Integer> resultIndices) {
  }

  private static void populateIndices(String str, HashMap<Character,Integer> characterIntegerHashMap, List<Integer> resultIndices, Integer matches) {

  }

  private static Integer populateHM(HashMap<Character,Integer> charFrequencyMap, String[] words) {
    Integer matches = 0 ;
    for(String word: words) {
      for(char c : word.toCharArray()) {
        if(charFrequencyMap.containsKey(c)) {
		  charFrequencyMap.put(c, charFrequencyMap.get(c) + 1);
		} else
		  charFrequencyMap.put(c, 1);
        matches++;
	  }
	}
	return matches;
  }

}
