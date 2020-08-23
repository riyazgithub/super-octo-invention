package com.year2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_oct5 {
  public int maxArea(int[] height) {
    int maxarea = 0;
    for(int i=0; i<height.length; i++) {
      for(int j=i+1; j<height.length;j++) {
        int tmparea = min(height[i],height[j]) * (j-i);
        if(maxarea<tmparea) {
          maxarea =tmparea;
        }
      }
    }
    return maxarea;
  }
private  int min(int i,int j) {
    if (i>j) return j;
    return i;
}

  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> keepTrack = new HashMap();
    for (String word: words) {
      keepTrack.put(word, keepTrack.getOrDefault(word, 0) + 1);
    }
    List<String> returnFrequent = new ArrayList(keepTrack.keySet());
    Collections.sort(returnFrequent, getStringComparator(keepTrack));

    return returnFrequent.subList(0, k);
  }

  private Comparator<String> getStringComparator(Map<String, Integer> keepTrack) {
    return (w1, w2) -> keepTrack.get(w1).equals(keepTrack.get(w2)) ?
        w1.compareTo(w2) : keepTrack.get(w2) - keepTrack.get(w1);
  }

  public static void main(String[] args) {
    int[] inputHeight = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    Solution_oct5 solutionOct5 = new Solution_oct5();
//    System.out.println(solutionOct5.maxArea(inputHeight));
    String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
    System.out.println(solutionOct5.topKFrequent(input,2));
  }

}