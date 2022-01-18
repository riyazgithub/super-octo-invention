package com.year2021.Feb;

public class removingDuplicates {

  public static int remove(int[] arr) {
	int left, right, distinctChars;
	left = right = 0;
	distinctChars = 1;
	while (right < arr.length) {
	  if(arr[left] != arr[right]){
	    left = right;
	    distinctChars ++;
	  }
	  right++;
	}
	return distinctChars;
  }

  public static void main(String[] args) {
	int targetIndices = removingDuplicates.remove(new int[] { 2, 3, 3, 3, 6, 9, 9 });
	System.out.println("Result  "+targetIndices);
	targetIndices = removingDuplicates.remove(new int[] {2, 2, 2, 2 });
	System.out.println("Result  "+targetIndices);

  }
}
