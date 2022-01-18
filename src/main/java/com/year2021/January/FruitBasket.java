package com.year2021.January;

public class FruitBasket {


  public static void main(String[] args) {
    String str = new String("ABCAC");
	System.out.println(SlidingWindow.findLength(str,2));
	str = new String("ABCBBC");
	System.out.println(SlidingWindow.findLength(str,2));
  }

}
