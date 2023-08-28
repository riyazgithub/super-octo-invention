package com.binary;

public class greaterBinaryTree {
    public static void main(String[] args) {
        int[] binaryTreeArray = {4,1,6,0,2,5,7,-1,-1,-1,3,-1,-1,-1,8}; // Example array representation

        TreeNode root = TreeUtils.arrayToTree(binaryTreeArray, 0);

        System.out.println("In-Order Traversal of Constructed Binary Tree:");
        TreeUtils.printInOrder(root);

        System.out.println("In-Order Traversal after greatersum ");
        TreeUtils.bstToGst(root);
        TreeUtils.printInOrder(root);
    }
}
