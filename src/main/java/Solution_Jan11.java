import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 *
 *
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5],[0,1,2],[3,4,6]]
 * Explanation:
 * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
 *
 *
 * Input: groupSizes = [2,1,3,3,3,2]
 * Output: [[1],[0,5],[2,3,4]]
 *
 */

class Solution_Jan11 {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> returnResult = new ArrayList<>();
    Map<Integer, List<Integer>> hm = new LinkedHashMap<>();
    for (int index = 0; index<groupSizes.length; index++) {
      List<Integer> valueList;
      if(hm.get(groupSizes[index]) == null) {
        hm.put(groupSizes[index], new ArrayList());
      }
      valueList = hm.get(groupSizes[index]);
      valueList.add(index);
      hm.put(groupSizes[index], valueList);
    }
    System.out.println(hm);
    for (Map.Entry<Integer,  List<Integer>> ME : hm.entrySet()){
      List<List<Integer>> partitions = partition(ME.getKey(), ME.getValue());
      returnResult.addAll(partitions);
    }
    return  returnResult;
  }

  private List<List<Integer>> partition(Integer key, List<Integer> value) {
    List<List<Integer>> partitions = new ArrayList<>();
    int rounds= value.size()/key;
    for(int i = 0; i<rounds; i++){
      List<Integer> group = new ArrayList<>();
      for (int counter =0; counter<key; counter++) {
        group.add(value.get(counter+(i*counter)));
      }
      partitions.add(group);
    }
    return partitions;
  }

  public static void main(String[] args) {
//    int[] groupSizes = {3,3,3,3,3,1,3};
    int[] groupSizes = {2,1,3,3,3,2};
    Solution_Jan11 solution = new Solution_Jan11();
    System.out.println(solution.groupThePeople(groupSizes));
  }
}