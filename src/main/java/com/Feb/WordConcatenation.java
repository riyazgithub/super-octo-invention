package com.Feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Copied

public class WordConcatenation {

  public static List<Integer> findWordConcatenation(String str, String[] words) {
	Map<String, Integer> wordFrequencyMap = new HashMap<>();
	for (String word : words)
	  wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

	List<Integer> resultIndices = new ArrayList<Integer>();
	int wordsCount = words.length, wordLength = words[0].length();

	for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
	  Map<String, Integer> wordsSeen = new HashMap<>();
	  for (int j = 0; j < wordsCount; j++) {
		int nextWordIndex = i + j * wordLength;
		// get the next word from the string
		String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
		if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
		  break;

		wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

		// no need to process further if the word has higher frequency than required
		if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
		  break;

		if (j + 1 == wordsCount) // store index if we have found all the words
		  resultIndices.add(i);
	  }
	}

	return resultIndices;
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

  public static void main(String[] args) {
    String[] words = {"cat","fox"};
	System.out.println("Words Outside "+words.length);
	System.out.println(WordConcatenation.findWordConcatenation("catfoxcat", words));
	System.out.println(WordConcatenation.findWordConcatenation("catcatfoxfox", words));
  }
}
