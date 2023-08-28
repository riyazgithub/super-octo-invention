package com.binary;

public class TreeUtils {
    public static TreeNode arrayToTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = arrayToTree(arr, 2 * index + 1); // Left child
        node.right = arrayToTree(arr, 2 * index + 2); // Right child

        return node;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    static int sum=0;
    public static void bstToGst(TreeNode root) {
        if(root == null)
            return;
        bstToGst(root.right);
        root.val = sum+ root.val;
        sum = root.val;
        bstToGst(root.left);

    }
}
