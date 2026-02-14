class Solution {
    public void countPath(TreeNode root, int targetSum, long currentSum, int [] counter){
        if(root == null) return;
        if(root.val + currentSum == targetSum) counter[0]++;
        countPath(root.left, targetSum, currentSum + root.val, counter);
        countPath(root.right, targetSum, currentSum + root.val, counter);
    }
    public void inOrder(TreeNode root, int [] counter, int targetSum){
        if(root == null) return;
        countPath(root, targetSum, 0, counter);
        inOrder(root.left, counter, targetSum);
        inOrder(root.right, counter, targetSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        int [] counter = new int[1];
        counter[0] = 0;
        inOrder(root, counter, targetSum);
        return counter[0];
    }
}