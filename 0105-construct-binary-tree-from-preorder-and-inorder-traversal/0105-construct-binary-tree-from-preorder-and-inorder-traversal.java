class Solution {
    public int searchRoot(int rootvalue, int [] inorder, int left, int right){
        for(int i = left; i <= right; i++){
            if(inorder[i] == rootvalue) return i;
        }
        return -1;
    }
    public TreeNode buildRoot(int [] rootIndex, int left, int right, int [] preorder, int [] inorder){
        if(rootIndex[0] == preorder.length || left > right) return null;
        TreeNode root = new TreeNode(preorder[rootIndex[0]]);
        int index = searchRoot(preorder[rootIndex[0]], inorder, left, right);
        rootIndex[0]++; 
        root.left = buildRoot(rootIndex, left, index - 1, preorder, inorder);
        root.right = buildRoot(rootIndex, index + 1, right, preorder, inorder);;
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int [] rootIndex = new int[1];
        rootIndex[0] = 0;
        TreeNode root = buildRoot(rootIndex, 0, inorder.length, preorder, inorder);
        return root;
    }
}