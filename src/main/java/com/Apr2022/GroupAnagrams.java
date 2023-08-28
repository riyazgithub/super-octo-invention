package com.Apr2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // group words by size
        HashMap <Integer, List<String>> wordsBySizeHM = new HashMap<>();
        for(String str : strs) {
            if(wordsBySizeHM.get(str.length()) == null) {
                List<String> wordsByLength = new ArrayList<>();
                wordsByLength.add(str);
                wordsBySizeHM.put(strs.length, wordsByLength);
            } else wordsBySizeHM.get(str.length()).add(str);
        }
        // group words by anagrams
        return new ArrayList<List<String>>();
    }

    public static void main(String[] args) {
        String[] inputStr = {"word", "sword", "drow", "rowd", "iced", "dice"};
        GroupAnagrams.groupAnagrams(inputStr);
    }
}
