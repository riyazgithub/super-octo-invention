package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {

	public List<Integer> getRow(int rowIndex) {
	  List<Integer> listRow = new ArrayList<>();
	  for(int i =1 ; i<=rowIndex+1; i++){
	      int calculatevalue = calculateval(rowIndex+1,i);
	      listRow.add(calculatevalue);
	  }
	  return listRow;
	}

  private int calculateval(int n, int m) {
	  if( m<=1 || m>=n || n==1)
	    return 1;
	  return calculateval(n-1,m-1) + calculateval(n-1,m);
  }

  public static void main(String[] args) {
	  pascalsTriangle psc = new pascalsTriangle();
	List<Integer> listRow = psc.getRow(3);
	System.out.println(listRow);
	listRow = psc.getRow(4);
	System.out.println(listRow);
	listRow = psc.getRow(29);
	System.out.println(listRow);

  }

}
