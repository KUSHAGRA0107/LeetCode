class Solution {
    public TreeNode buildRoot(int [] rootIndex, int left, int right, int [] preorder, int [] inorder, HashMap<Integer, Integer> map){
        if(rootIndex[0] == preorder.length || left > right) return null;
        TreeNode root = new TreeNode(preorder[rootIndex[0]]);
        int index = map.get(preorder[rootIndex[0]]);
        rootIndex[0]++; 
        root.left = buildRoot(rootIndex, left, index - 1, preorder, inorder, map);
        root.right = buildRoot(rootIndex, index + 1, right, preorder, inorder, map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        int [] rootIndex = new int[1];
        rootIndex[0] = 0;
        TreeNode root = buildRoot(rootIndex, 0, inorder.length, preorder, inorder,map);
        return root;
    }
}