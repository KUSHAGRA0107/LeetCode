class Solution {
    public void dfs(int start, int target, int [][] adj, List<Integer> path, List<List<Integer>> answer){
        if(start == target){
            answer.add(new ArrayList(path));
            return;
        }
        int [] neighbour = adj[start];
        for(int i = 0; i < neighbour.length; i++){
            path.add(neighbour[i]);
            dfs(neighbour[i], target, adj, path, answer);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        int start = 0;
        int target = graph.length - 1;
        path.add(0);
        dfs(start, target, graph, path, answer);
        return answer;
    }
}