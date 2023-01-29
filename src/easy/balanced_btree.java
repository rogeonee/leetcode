package easy;

public class balanced_btree {
    public static void main(String[] args) {

    }

    boolean ans = true;

    public int solve(TreeNode root) {
        if(root == null)
            return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        if(Math.abs(left-right)>1)
            ans = false;
        
        return Math.max(left,right)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return ans;
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
