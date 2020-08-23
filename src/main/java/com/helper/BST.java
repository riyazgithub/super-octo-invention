package com.helper;

public class BST {

// Inset in to BST
  public TreeNode insertIntoBST(TreeNode root, int val) {
    root = insertRecursive(root,val);
    return root;
  }

  public TreeNode insertRecursive(TreeNode treeNode, int newVal) {
    if(treeNode==null) {
      return new TreeNode(newVal);
    } else if(treeNode.val > newVal) {
      treeNode.left = insertRecursive(treeNode.left,newVal);
    }else if(treeNode.val < newVal){
      treeNode.right = insertRecursive(treeNode.right, newVal);
    }else {
      return treeNode;
    }
    return treeNode;
  }

  public void inorderTraversal(TreeNode treeNode){
    if(treeNode == null)
      return;
    inorderTraversal(treeNode.left);
    System.out.print(treeNode.val + " ");
    inorderTraversal(treeNode.right);
  }
}