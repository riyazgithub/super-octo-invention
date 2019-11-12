public class BinaryTree {

  public TreeNode root;

  public static class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public Object data;

    public TreeNode(Object data) {
      this.data = data;
      left = right = null;
    }
  }

  public static TreeNode insertionRecursive(TreeNode root, int value) {

    if (root == null)
      return new TreeNode(value);

    if (value < (int) root.data) {
      root.left = insertionRecursive(root.left, value);
    } else if (value > (int) root.data) {
      root.right = insertionRecursive(root.right, value);
    }

    return root;

  }

  public static void printInorderTraversal(TreeNode root) {
    if (root != null) {
      printInorderTraversal(root.left);
      System.out.print(root.data + " ");
      printInorderTraversal(root.right);
    }
  }
}