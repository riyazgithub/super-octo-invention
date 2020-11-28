package Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 */

public class MaxLengthofStr {

  public int maxLength(List<String> arr) {
    int maxLength = 0;
	List<String> patternHolder = new ArrayList<>();
    // Step 1 Forming patterns
	for (String str : arr) {
	  updateAndMerge(str,arr,patternHolder);
	}
	System.out.println(patternHolder);
	// parse through the pattern and eliminate the dupes
	List<String> updatedPatternHolder = parseThroughPatternAndRemoveDupes(patternHolder);
	System.out.println(updatedPatternHolder);
	// Find the maxlength ones
	for (String str : updatedPatternHolder)
	{
	  if(str.length() > maxLength)
	    maxLength = str.length();
	}
	System.out.println(maxLength);
    return maxLength;
  }

  private List<String> parseThroughPatternAndRemoveDupes(List<String> patternHolder) {
    List<Integer> indexPosition = new ArrayList<>();
	List<String> UpdatedpatternHolder = new ArrayList<>();
    for(int i =0; i< patternHolder.size(); i++){
      boolean findDupes = calculateDupes(patternHolder.get(i));
      if(!findDupes)
        UpdatedpatternHolder.add(patternHolder.get(i));
	}
	return UpdatedpatternHolder;
  }

  private boolean calculateDupes(String s) {
    boolean isDupe = false;
    char[] arrayOfChars = s.toCharArray();
	HashMap<Character, Integer> mapOfOccurences = new HashMap<>();
	for (char c : arrayOfChars) {
	  Integer value = mapOfOccurences.get(c);
	  if(value == null) {
	    mapOfOccurences.put(c,1);
	  }
	  else
	    return true;
	}
    return isDupe;
  }

  private void updateAndMerge(String key, List<String> arr, List<String> patternHolder) {
	for (String str : arr) {
	  if(!key.equals(str)){
	    patternHolder.add(str.concat(key));
	  } else
		patternHolder.add(key);
	}
  }

  public static void main(String[] args) {
	List<String> arr = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
	MaxLengthofStr maxLengthofStr = new MaxLengthofStr();
	maxLengthofStr.maxLength(arr);

  }

}
