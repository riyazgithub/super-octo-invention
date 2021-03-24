package com.Mar;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
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
        String words[] = {"word", "sword", "drow", "rowd", "iced", "dice"};
        List<List<String>> anagrams = groupAnagrams(words);
        System.out.println("Anagrams List "+anagrams);
    }
}
