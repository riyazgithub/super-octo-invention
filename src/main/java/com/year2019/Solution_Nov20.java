package com.year2019;

import com.year2021.helper.BST;
import com.year2021.helper.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_Nov20 {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    TreeNode treeMerged = new TreeNode(0);

    mergeTrees(t1,t2,treeMerged);
    return treeMerged;
  }

  private void mergeTrees(TreeNode t1, TreeNode t2, TreeNode treeMerged) {
    if(t1 == null && t2 ==null){
      return;
    }
  }

  public static void main(String[] args) {
    BST solutionNov15 = new BST();
    TreeNode tree1 = solutionNov15.insertRecursive(null, 10);
    tree1 = solutionNov15.insertIntoBST(tree1,4);
    tree1 = solutionNov15.insertIntoBST(tree1,7);
    tree1 = solutionNov15.insertIntoBST(tree1,1);
    tree1 = solutionNov15.insertIntoBST(tree1,14);
    System.out.println();
    solutionNov15.inorderTraversal(tree1);
    System.out.println();

    TreeNode tree2 = solutionNov15.insertRecursive(null, 15);
    tree2 = solutionNov15.insertIntoBST(tree2,5);
    tree2 = solutionNov15.insertIntoBST(tree2,3);
    tree2 = solutionNov15.insertIntoBST(tree2,20);
    tree2 = solutionNov15.insertIntoBST(tree2,23);
    tree2 = solutionNov15.insertIntoBST(tree2,19);
    System.out.println();
    solutionNov15.inorderTraversal(tree2);
    System.out.println();




  }
}