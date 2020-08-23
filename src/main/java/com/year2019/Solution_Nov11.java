package com.year2019;

import java.util.Stack;

class Solution_Nov11 {

  // https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/


  /*
        You are given a string s that consists of lower case English letters and brackets.

        Reverse the strings in each pair of matching parentheses, starting from the innermost one.

        Your result should not contain any brackets.



        Example 1:

        Input: s = "(abcd)"
        Output: "dcba"
        Example 2:

        Input: s = "(u(love)i)"
        Output: "iloveu"
        Explanation: The substring "love" is reversed first, then the whole string is reversed.
        Example 3:

        Input: s = "(ed(et(oc))el)"
        Output: "leetcode"
        Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
        Example 4:

        Input: s = "a(bcdefghijkl(mno)p)q"
        Output: "apmnolkjihgfedcbq"


        Constraints:

        0 <= s.length <= 2000
        s only contains lower case English characters and parentheses.
        It's guaranteed that all parentheses are balanced.
   */

  /**
   *
   * @param s
   * @return
   */

  public String reverseParenthesesCore(String s) {

    String returnString = new String();
    char[] inputChars = s.toCharArray();
    int index = 0;
    Stack<Character> stack = new Stack();
    for(;index<inputChars.length;index++) {
      if(inputChars[index] != ')') {
        stack.push(inputChars[index]);
      } else {
        // continue popping until you enconunter a open paranthesis
        char pop = stack.pop();
        while (pop != '(') {
          returnString = returnString + pop;
          pop = stack.pop();
        }
        if(stack.size() > 0) {
          // the round still continues
          //pushthestringbackin
          pushthestringbackin(stack,returnString);
          // reset the return string
          returnString = new String();
        }
      }
    }
    return returnString;
  }

  public String reverseParentheses(String s) {
    String returnString = new String();
    if(s.charAt(0) != '(') {
      if(!s.contains("(")){
        return s;
      }
      String tmp = s.substring(s.indexOf('('),s.lastIndexOf(')')+1);
      returnString = s.replace(tmp, reverseParenthesesCore(tmp));
    } else {
      returnString = reverseParenthesesCore(s);
    }

    return returnString;
  }

  private void pushthestringbackin(Stack<Character> stack, String returnString) {
    char[] inputChars = returnString.toCharArray();
    for (char c : inputChars) {
      stack.push(c);
    }
  }

  public static void main(String[] args) {
    Solution_Nov11 solutionNov11 = new Solution_Nov11();
    System.out.println(solutionNov11.reverseParentheses("(abcd)"));
    System.out.println(solutionNov11.reverseParentheses("(u(love)i)"));
    System.out.println(solutionNov11.reverseParentheses("(ed(et(oc))el)"));
    System.out.println(solutionNov11.reverseParentheses("a(bcdefghijkl(mno)p)q"));

  }
}   