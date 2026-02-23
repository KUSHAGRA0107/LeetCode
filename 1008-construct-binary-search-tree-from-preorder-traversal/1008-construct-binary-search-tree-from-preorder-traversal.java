class Solution {
    public TreeNode buildTree(int [] preorder, int low, int high){
        if(low > high) return null;
        TreeNode root = new TreeNode(preorder[low]);
        int mid = high + 1;

        for(int i = low + 1; i <= high; i++){
            if(preorder[low] < preorder[i]) {
                mid = i;
                break;
            }
        }
        
        root.left = buildTree(preorder, low + 1, mid - 1);
        root.right = buildTree(preorder, mid , high);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);
    }
}