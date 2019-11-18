import com.helper.TreeNode;

class Solution {


  public TreeNode insertIntoBST(TreeNode root, int val) {
    root = insertRecursive(root,val);
    return root;
  }

  private TreeNode insertRecursive(TreeNode treeNode, int newVal) {
    if(treeNode==null) {
      return new TreeNode(newVal);
    } else if(treeNode.data > newVal) {
      treeNode.left = insertRecursive(treeNode.left,newVal);
    }else if(treeNode.data < newVal){
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
    System.out.print(treeNode.data + " ");
    inorderTraversal(treeNode.right);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = solution.insertRecursive(null, 10);
    root = solution.insertIntoBST(root,1);
    root = solution.insertIntoBST(root,2);
    root = solution.insertIntoBST(root,11);
    root = solution.insertIntoBST(root,5);
    root = solution.insertIntoBST(root,19);
    root = solution.insertIntoBST(root,13);
    System.out.println();
    solution.inorderTraversal(root);
    System.out.println();

  }
}