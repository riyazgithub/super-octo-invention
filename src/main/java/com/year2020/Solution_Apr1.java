package com.year2020;

class Solution_Apr1 {
  public int removeCoveredIntervals(int[][] intervals) {
    int returnInt = 0;
    for (int i=0;i<intervals.length;i++) {
      int[] checkInterval = intervals[i];
      for(int j=0;j<intervals.length;j++) {
		int[] compareInterval = intervals[j];
		if(i!=j && compareInterval[0]<=checkInterval[0] && compareInterval[1]>=checkInterval[1]) {
		  returnInt++;
		  break;
		}
	  }
	}
    return intervals.length - returnInt;
  }

  public static void main(String[] args) {
	Solution_Apr1 solutionApr1 = new Solution_Apr1();
	int[][] intervals= {{1,4},{3,6},{2,8}};
	int[][] intervals1= {{34335,39239},{15875,91969},{29673,66453},{53548,69161},{40618,93111}};
	System.out.println(solutionApr1.removeCoveredIntervals(intervals));
  }
}