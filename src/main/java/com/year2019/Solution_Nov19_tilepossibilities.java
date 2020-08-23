package com.year2019;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution_Nov19_tilepossibilities {

  Set tilePossibilities = new LinkedHashSet();
  static Set tilePossibilitiesStatic = new LinkedHashSet();

  static void printAllKLength(char[] set, int k)
  {
    int n = set.length;
    printAllKLengthRec(set, "", n, k);
  }

  // The main recursive method
// to print all possible
// strings of length k
  static void printAllKLengthRec(char[] set,
      String prefix,
      int n, int k) {

    // Base case: k is 0,
    // print prefix
    if (k == 0) {
      tilePossibilitiesStatic.add(prefix);
//      System.out.println(prefix);
      return;
    }

    // One by one add all characters
    // from set and recursively
    // call for k equals to k-1
    for (int i = 0; i < n; ++i) {

      // Next character of input added
      String newPrefix = prefix + set[i];

      // k is decreased, because
      // we have added a new character
      printAllKLengthRec(set, newPrefix,
          n, k - 1);
    }
  }

    public int numTilePossibilities(String tiles) {

    char[] tileChar = tiles.toCharArray();
    for (int i = 1; i<= tileChar.length; i++) {
      numTilePossibilities(tileChar,"", tileChar.length,i);
    }

    return tilePossibilities.size();
  }

  private void numTilePossibilities(char[] tileChar, String prefix, int length, int index) {
    if(index == 0){
      tilePossibilities.add(prefix);
      return;
    }
    for(int i=0; i<length; ++i){
      String newprefix = prefix + tileChar[i];
      numTilePossibilities(tileChar, newprefix, length, index-1);
    }
  }

  public static void main(String[] args) {
    Solution_Nov19_tilepossibilities solutionNov19tilepossibilities = new Solution_Nov19_tilepossibilities();
    System.out.println(solutionNov19tilepossibilities.numTilePossibilities("AAABBC"));
    Solution_Nov19_tilepossibilities.printAllKLength("AAABBC".toCharArray(), 6);
    System.out.println(" Static sum "+ Solution_Nov19_tilepossibilities.tilePossibilitiesStatic.size());
  }
}
