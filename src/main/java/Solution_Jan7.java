public class Solution_Jan7 {


  /**
   *
   * https://leetcode.com/problems/xor-queries-of-a-subarray/
   *
   */


  public int[] xorQueries(int[] arr, int[][] queries) {
    int[] returnArr = new int[queries.length];
    for (int i=0; i<queries.length; i++) {
      int[] range = queries[i];
      int result = 0;
      for (int j = range[0]; j<=range[1]; j++) {
        result = result ^ arr[j];
      }
      System.out.println(range[0]+" , "+range[1]+ " : "+result);
      returnArr[i] = result;
    }
    return returnArr;

  }

  public static void main(String[] args) {

    int[] arr = {1,3,4,8};
    int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
    Solution_Jan7 solution = new Solution_Jan7();
    solution.xorQueries(arr,queries);
  }
}
