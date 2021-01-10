package com.year2020;

import java.util.ArrayList;
import java.util.List;

public class Solution_numOfDigits_sept {
  public boolean isArmstrong(int N) {
    boolean isArm = true;
    int numberOfDigits = getNumberOfDigits(N);
	System.out.println(numberOfDigits);
	List<Integer> integerList = convertToIntegerList(N,numberOfDigits);
    return isArm;
  }

  private List<Integer> convertToIntegerList(int n, int numberOfDigits) {
	List<Integer> integerList = new ArrayList<>();
	for(int i =numberOfDigits-1; i>=1; i--) {
	  double divident = (Math.pow(10,i));
	  int temp = n/(int)divident;
	  integerList.add(temp);
	}
	System.out.println(integerList);
	return integerList;
  }

  private int getNumberOfDigits(int N) {
	int numberOfDigits =0;
	int operator = 1;
	while(N/operator != 0) {
	  numberOfDigits++;
	  operator = operator * 10;
	}
	return numberOfDigits;
  }

  public static void main(String[] args) {
	Solution_numOfDigits_sept solutionNumOfDigitssept = new Solution_numOfDigits_sept();
	System.out.println(solutionNumOfDigitssept.isArmstrong(1145));
  }
}