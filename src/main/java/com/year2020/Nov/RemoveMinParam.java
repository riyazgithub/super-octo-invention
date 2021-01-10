package com.year2020.Nov;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class RemoveMinParam {

  public String minRemoveToMakeValid(String s) {
    String returnVAlidStr = new String();
	Stack<Integer> openParamHolder = new Stack<>();
	Stack<Integer> closeParamHolder = new Stack<>();
	char[] inputArr = s.toCharArray();
	// parsing phase
	for (int i =0; i<inputArr.length; i++){
	  if(inputArr[i] == '(')
	    openParamHolder.push(i);
	  else if (inputArr[i] == ')')
	  {
	    if(openParamHolder.size() == 0){
	      closeParamHolder.push(i);
		} else
		  openParamHolder.pop();
	  }

	}
	System.out.println("Open Index " + openParamHolder);
	System.out.println("Close Index " + closeParamHolder);
	returnVAlidStr = formNewString(openParamHolder,closeParamHolder,s);
	System.out.println("Valid String: " + returnVAlidStr);
    return returnVAlidStr;
  }

  private String formNewString(Stack<Integer> openParamHolder, Stack<Integer> closeParamHolder, String s) {
	List<Integer> combinedList = new ArrayList<>();
	while (openParamHolder.size() > 0 || closeParamHolder.size() > 0) {
	  if(openParamHolder.size() > 0 ) {
	    combinedList.add(openParamHolder.pop());
	  } else {
		combinedList.add(closeParamHolder.pop());
	  }
	}
	String returnStr = new String();
	char[] inputArr = s.toCharArray();
	for(int i =0;i<inputArr.length; i++){
	  if(!combinedList.contains(i)){
	    returnStr += inputArr[i];
	  }
	}
	return returnStr;
  }

  public static void main(String[] args) {
    RemoveMinParam removeMinParam = new RemoveMinParam();
    String inputStr =  new String("lee(t(c)o)de)");
	System.out.println("Input "+ inputStr);
    removeMinParam.minRemoveToMakeValid(inputStr);

	System.out.println();
    inputStr =  new String("a)b(c)d");
	System.out.println("Input "+ inputStr);
	removeMinParam.minRemoveToMakeValid(inputStr);
//
	System.out.println();
	inputStr =  new String("(a(b(c)d)");
	System.out.println("Input "+ inputStr);
	removeMinParam.minRemoveToMakeValid(inputStr);
  }
}
