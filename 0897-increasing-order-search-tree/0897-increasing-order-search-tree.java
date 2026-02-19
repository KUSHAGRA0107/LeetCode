class Solution {
    private void getInOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        getInOrder(root.left, list);
        list.add(root);
        getInOrder(root.right, list);
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        getInOrder(root, list);
        TreeNode temp = null;
        root = list.get(0);
        temp = list.get(0);
        for(int i = 1; i < list.size(); i++){
            TreeNode node = list.get(i);
            node.left = null;
            node.right = null;
            temp.right = node;
            temp = node;
        }
        return root;
    }
}