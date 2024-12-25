class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        queue.offerLast(root);
        while(queue.size() != 0){
            int currsize = queue.size();
            int max = Integer.MIN_VALUE;
            while(currsize != 0){
                TreeNode node = queue.pollFirst();
                max = Math.max(max, node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
                currsize -= 1;
            }
            answer.add(max);
        }
        return answer;
    }
}