
public class Solution {

  public void dfs(int[][] friendship,int[] visited, int i) {
    for(int j=0;j<friendship.length; j++) {
      if(friendship[i][j]==1 && visited[j] == 0){
        visited[j] =1;
        dfs(friendship,visited,j);
      }
    }
  }
  public int findCircleNum(int[][] M) {
    int[] visited = new int[M.length];
    int count = 0;
    for(int i=0;i<M.length;i++){
      if(visited[i]==0) {
        dfs(M, visited,i);
        count++;
      }
    }
    return count;

  }



  public static void main(String[] args) {
    Solution solution = new Solution();
    int [][] sampleInput = {{1,1,0},
        {1,1,0},
        {0,0,1}};
//    System.out.println(solution.findCircleNum(sampleInput));
    BinaryTree tree = new BinaryTree();
    tree.root = BinaryTree.insertionRecursive(tree.root, 24);
    tree.root = BinaryTree.insertionRecursive(tree.root, 2);
    tree.root = BinaryTree.insertionRecursive(tree.root, 33);
    tree.root = BinaryTree.insertionRecursive(tree.root, 11);


    BinaryTree.printInorderTraversal(tree.root);



  }
}
