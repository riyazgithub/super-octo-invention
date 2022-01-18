package com.year2019;

import com.year2021.helper.BST;
import com.year2021.helper.TreeNode;

public class Solution_Nov15 {

  public static void main(String[] args) {
    BST solutionNov15 = new BST();
    TreeNode root = solutionNov15.insertRecursive(null, 10);
    root = solutionNov15.insertIntoBST(root,1);
    root = solutionNov15.insertIntoBST(root,2);
    root = solutionNov15.insertIntoBST(root,11);
    root = solutionNov15.insertIntoBST(root,5);
    root = solutionNov15.insertIntoBST(root,19);
    root = solutionNov15.insertIntoBST(root,13);
    System.out.println();
    solutionNov15.inorderTraversal(root);
    System.out.println();

  }

}
