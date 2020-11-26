package com.recursion;

class reverseString {

  public void reverseString(char[] s) {
    char[] rev = new char[s.length];
    helper(0, s, rev);
    copyChars(s,rev);
  }

  private void copyChars(char[] s, char[] rev) {
    for (int i =0; i< rev.length; i++){
      s[i] = rev[i];
    }
  }

  private void helper(int i, char[] s, char[] rev) {
    if(i>=s.length)
      return;
    helper(i+1,s, rev);
    rev[s.length-i-1] = s[i];

  }

  public static void main(String[] args) {
    reverseString solution = new reverseString();
    char[] s;
//	s = new char[]{'H','a','n','n','a','h','1'};
    s = new char[]{'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};

	solution.reverseString(s);
    System.out.println("Reversed String "+String.valueOf(s));

  }
}