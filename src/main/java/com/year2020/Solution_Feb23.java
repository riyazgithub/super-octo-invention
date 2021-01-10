package com.year2020;

import com.helper.BST;
import com.helper.TreeNode;
import java.util.HashMap;

class Solution_Feb23 {
  public int deepestLeavesSum(TreeNode root) {
    int returnInt=-1;
	HashMap<Integer, Integer> hm = new HashMap<>();
	inorderTraversalWithLevel(root,1, hm);
	returnInt = hm.get(hm.size());
    return returnInt;
  }

  public void inorderTraversalWithLevel(TreeNode treeNode, int level, HashMap hashMap){
	if(treeNode == null)
	  return;
	inorderTraversalWithLevel(treeNode.left, level+1, hashMap);
//	System.out.print(treeNode.val + " Level: "+level+" ");
	if(hashMap.get(level) ==null) {
	  hashMap.put(level, 0);
	}
	Integer val = (Integer) hashMap.get(level);
	val += treeNode.val;
	hashMap.put(level, val);
	inorderTraversalWithLevel(treeNode.right, level+1, hashMap);
  }

  public static void main(String[] args) {
    Solution_Feb23 solutionFeb23 = new Solution_Feb23();
	HashMap<Integer, Integer> hm = new HashMap<>();
	TreeNode root = solutionFeb23.initializeBinaryTree();
	System.out.println();
	solutionFeb23.inorderTraversalWithLevel(root,1, hm);
	System.out.println();
	System.out.println("HashMap Value "+hm);
	System.out.println("Solution_Feb23 : "+ solutionFeb23.deepestLeavesSum(root));

  }

  private TreeNode initializeBinaryTree() {
	BST solutionNov15 = new BST();
	TreeNode root = solutionNov15.insertRecursive(null, 10);
	root = solutionNov15.insertIntoBST(root,4);
	root = solutionNov15.insertIntoBST(root,6);
	root = solutionNov15.insertIntoBST(root,11);
	root = solutionNov15.insertIntoBST(root,5);
	root = solutionNov15.insertIntoBST(root,19);
	root = solutionNov15.insertIntoBST(root,13);
	System.out.println();
	solutionNov15.inorderTraversal(root);
	System.out.println();
	return root;
  }
}