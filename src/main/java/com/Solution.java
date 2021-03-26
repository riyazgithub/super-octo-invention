package com;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
	Scanner scanner = new Scanner((System.in));
	Integer lines = Integer.valueOf(scanner.nextLine());
	ArrayList<String> initialInput = new ArrayList<>();
	HashMap<String, shareDetails> shareMap = new HashMap<>();
	for(int i =1;i<=lines;i++){
	  System.out.println("Enter line "+i);
	  String input = scanner.nextLine();
	  initialInput.add(input);
	}
	System.out.println("Input is "+initialInput);
	// parsing the input

	for(String eachLine: initialInput) {

	  String[] eachField = eachLine.split(",");
	  Double value = Double.valueOf(eachField[3]);
	  Double count = Double.valueOf(eachField[4]);

	  if(shareMap.containsKey(eachField[2])) {

	    shareDetails sd = shareMap.get(eachField[2]);
	    double totalCost = (sd.value + (value*count));
	    shareMap.put(eachField[2],new shareDetails(totalCost, count+sd.count+count));
	  } else {
	    shareMap.put(eachField[2], new shareDetails(value*count, count)); //4800.00. 1.5
	  }
	}
	for (String string : shareMap.keySet()){
	  System.out.println(string+","+shareMap.get(string));
	}
	System.out.println("Share Details "+shareMap);
  }
}
