class Solution {
    public TreeNode buildRoot(int [] rootIndex, int left, int right, int [] inorder, int [] postorder, HashMap<Integer, Integer> map){
        if(rootIndex[0] == inorder.length || left > right) return null;
        TreeNode root = new TreeNode(postorder[rootIndex[0]]);
        int index = map.get(postorder[rootIndex[0]]);
        rootIndex[0]--;
        root.right = buildRoot(rootIndex, index + 1 , right, inorder, postorder, map);
        root.left =  buildRoot(rootIndex, left , index - 1, inorder, postorder, map);;
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        int [] rootIdx = new int[1];
        rootIdx[0] = inorder.length - 1;
        TreeNode root = buildRoot(rootIdx, 0, inorder.length - 1, inorder, postorder, map);
        return root;
    }
}