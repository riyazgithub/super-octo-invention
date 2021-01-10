package com.year2020;

import java.util.Stack;

public class Solution_Jan13 {

  /**
   * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
   *
   * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')',
   * and in any positions ) so that the resulting parentheses string is valid.
   *
   * Input: "())"
   * Output: 1
   *
   * Input: "((("
   * Output: 3
   *
   * Input ""()))((""
   * Output 4
   */
  public int minAddToMakeValid(String S) {
    int returnInt =0;
    char[] chars = S.toCharArray();
    Stack<Character> stack = new Stack<>();
    for(char c : chars)
    {
      if(c == '(')
        stack.push(c);
      else if(c == ')')
      {
        if(stack.size() ==0 )
          returnInt++;
        else
        stack.pop();
      }
    }
    return returnInt + stack.size();
  }

  public static void main(String[] args) {
    Solution_Jan13 solution_jan13 = new Solution_Jan13();
    System.out.println(solution_jan13.minAddToMakeValid("())"));
    System.out.println(solution_jan13.minAddToMakeValid("((("));
    System.out.println(solution_jan13.minAddToMakeValid("()))(("));


  }
}
