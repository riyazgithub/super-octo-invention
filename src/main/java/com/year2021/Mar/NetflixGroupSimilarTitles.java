package com.year2021.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetflixGroupSimilarTitles {

  public static List<List<String>> groupTitles(String[] strs){
	if (strs.length == 0)
	  return new ArrayList<List<String>>();

	Map<String, List<String>> res = new HashMap<String, List<String>>();

	int[] count = new int[26];
	for (String s : strs) {
	  Arrays.fill(count, 0);
	  for (char c : s.toCharArray()){
		int index = c - 'a';
		count[index]++;
	  }

	  StringBuilder delimStr = new StringBuilder("");
	  for (int i = 0; i < 26; i++) {
		delimStr.append('#');
		delimStr.append(count[i]);
	  }

	  String key = delimStr.toString();
	  if (!res.containsKey(key))
		res.put(key, new ArrayList<String>());

	  res.get(key).add(s);
	}

	return new ArrayList<List<String>>(res.values());
  }

  public static void main(String[] args) {
	// Driver code
	String titles[] = {"duel","dule","speed","spede","eedsp","deul","cars"};

	List<List<String>> gt = groupTitles(titles);
	String query = "spede";
	  System.out.println("GT "+gt);
	// Searching for all titles
	for (List<String> g : gt){
	  if (g.contains(query))
		System.out.println(g);
	}
  }

}
