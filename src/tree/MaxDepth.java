package tree;

class maxDepth {
    public int maxDepth(TreeNode root){
        int ldepth = 0;
        int rdepth = 0;
        if (root == null)
            return -1;
        if (root.left != null){
            ldepth = maxDepth(root.left) + 1;
        }
        if (root.right != null){
            rdepth = maxDepth(root.right) + 1;
        }
        return Math.max(ldepth, rdepth);
    }
}
