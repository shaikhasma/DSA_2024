import java.util.ArrayList;
import java.util.List;

/**
    Binary Tree : Inorder Traversal by Asma
  */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.data = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}


public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
      ArrayList<Integer> inorder = new ArrayList<Integer>();
      
      inorder(root, inorder);

      return inorder;

    }
    
     public void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;

        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
     }
}

/**
   TC : 0(N)
   SC : 0(N) stack space
 */