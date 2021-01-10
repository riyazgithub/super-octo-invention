package com.year2020;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Solution_Jan16 {

  /**
   * https://leetcode.com/problems/find-and-replace-pattern/
   *
   *
   * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
   * Output: ["mee","aqq"]
   * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
   * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
   * since a and b map to the same letter.
   *
   *
   */

  public List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> returnList = new ArrayList<>();
    String patternCode = extractSequence(pattern);
    System.out.println(patternCode);
    for(String word : words) {
      String wordPattern = extractSequence(word);
      if(isPatternMatch(patternCode,wordPattern)) {
        returnList.add(word);
      }
    }
    return returnList;
  }

  private boolean isPatternMatch(String patternCode, String wordPattern) {
    char[] patternCodeChar = patternCode.toCharArray();
    char[] wordPatternChar = wordPattern.toCharArray();
    if(patternCode.length() != wordPattern.length())
      return false;
    for(int i =1 ;i<wordPattern.length(); i= i+2){
      if(patternCodeChar[i] != wordPatternChar[i])
        return false;
    }
    return true;
  }

  private String extractSequence(String pattern) {
    int count =1;
    int sequenceNumber=1;
    char[] sequenceChars = pattern.toCharArray();
    LinkedHashMap<Integer,String> seqHM = new LinkedHashMap<>();
    String returnStr = new String();
    if(pattern.length() > 0 ) {
      char prevChar = sequenceChars[0];
      for(int i = 1;i<sequenceChars.length;i++) {
        if(prevChar == sequenceChars[i]) {
          count++;
        }else {
          seqHM.put(sequenceNumber,prevChar+""+count);
          sequenceNumber++;
          prevChar = sequenceChars[i];
          count = 1;
        }
      }
      seqHM.put(sequenceNumber,prevChar+""+count);
    }
    for (int i =1; i<=sequenceNumber; i++) {
      returnStr = returnStr+seqHM.get(i);
    }
    return returnStr;
  }

  public static void main(String[] args) {

    Solution_Jan16 solutionJan16 = new Solution_Jan16();
//    String[] strArr = {"abc","deq","mee","aqq","dkd","ccc"};
    String[] strArr = {"abc","cba","xyx","yxx","yyx"};
    solutionJan16.findAndReplacePattern(strArr, "abc");
  }
}
