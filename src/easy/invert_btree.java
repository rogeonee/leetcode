package easy;

public class invert_btree {
    public static void main(String[] args) {

    }

    public static tNode invertTree(tNode root) {
        // Base case: if the tree is empty
        if(root == null)
            return root;
        
        // Call the function recursively for the left subtree
        invertTree(root.left);
        // Call the function recursively for the right subtree
        invertTree(root.right);
        
        // Swap
        tNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    
}

class tNode {
    int val;
    tNode left;
    tNode right;
    tNode() {}
    tNode(int val) { this.val = val; }
    tNode(int val, tNode left, tNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
