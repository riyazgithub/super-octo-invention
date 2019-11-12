import java.util.HashMap;
import java.util.Map;

class Solution_oct1 {
  public String removeVowels(String S) {
    String returnStr = new String();
    HashMap<Character, Integer> em = new HashMap<Character, Integer>();
    em.put('a',1);
    em.put('e',1);
    em.put('i',1);
    em.put('o',1);
    em.put('u',1);
    char[] arrayOfChars = S.toCharArray();
    for(Character character :arrayOfChars) {
      if(em.get(character) == null) {
        returnStr += character;
      }
    }
    return returnStr;
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int otherone = target - nums[i];
      if (map.containsKey(otherone) && map.get(otherone) != i) {
        return new int[] { i, map.get(otherone) };
      }
    }
    return new int[] { -1, -1 };
  }

  public int countSegments(String s) {
    int returnInt = 0;
    int tmpCount = 0;
    boolean itsaword = true;
    char[] arrayOfChars = s.toCharArray();
    for(int index =0; index<arrayOfChars.length; index++) {
      if(arrayOfChars[index]== ' ') {
        if(itsaword) {
          tmpCount++;
          itsaword = false;
        }
        if((index+1) < arrayOfChars.length && arrayOfChars[index+1] != ' ' && itsaword) {
          itsaword = false;
        }
      }else {
        itsaword = true;
      }
      if(arrayOfChars[arrayOfChars.length-1] != ' ')
      returnInt = tmpCount +1;
      else
        returnInt = tmpCount;
    }
    return returnInt;
  }
  public static void main(String[] args) {

    Solution_oct1 sol = new Solution_oct1();
//    int[] nums = {11,2,7, 15};
//    int[] returnIndices = sol.twoSum(nums,9);

    int[] nums = {3, 3};
    int[] returnIndices = sol.twoSum(nums,6);
//    int[] nums = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
//    int[] returnIndices = sol.twoSum(nums,542);
//    int[] nums = {2222222, 2222222};
//    int[] returnIndices = sol.twoSum(nums,4444444);

// ==============================
    String inputStr = new String("Of all the gin joints in all the towns in all the world ");
    System.out.println(sol.countSegments(inputStr));
  }

}