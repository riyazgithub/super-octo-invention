import java.util.ArrayList;
import java.util.List;

class Solution_oct7 {
  ArrayList<List<Integer>> r;
  int[] values;
  int[] counts;

  void helper(int p, int n) {
    if (p >= values.length) {
      if (n == 0) {
        ArrayList<Integer> x = new ArrayList();
        r.add(x);
        for (int i=0; i<values.length; i++) {
          Integer v = values[i];
          for (int j=0; j<counts[i]; j++) {
            x.add(v);
          }
        }
      }
      return;
    }
    for (int c=0; ; c++) {
      int s = c * values[p];
      if (s > n) {
        break;
      }
      counts[p] = c;
      helper(p+1, n-s);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    r = new ArrayList();
    values = candidates;
    counts = new int[values.length];
    helper(0, target);
    return r;
  }

  public static void main(String[] args) {
    Solution_oct7 sol = new Solution_oct7();
    int[] nums = {2,3,5};
    System.out.println(sol.combinationSum(nums,7));
  }
}
