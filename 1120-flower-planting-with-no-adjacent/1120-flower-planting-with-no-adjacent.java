class Solution {
    public boolean isSafepath(int node, int currCol, ArrayList<List<Integer>>adj, int [] color){
        for(int itr: adj.get(node)){
            if(color[itr] == currCol) return false;
        }return true;
    }
    public boolean isPossible(int node, int n, int [] color,  ArrayList<List<Integer>>adj, int m){
        if(node == n) return true;
        for(int i = 1; i <= m; i++){
            if(isSafepath(node, i, adj, color) == true){
                color[node] = i;
                if(isPossible(node + 1, n, color, adj, m) == true){
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList());
        }
        int [] color = new int[n];
        for(int i = 0; i < paths.length; i++){
            int u = paths[i][0];
            int v = paths[i][1];
            adj.get(u - 1).add(v - 1);
            adj.get(v - 1).add(u - 1);
        }
        isPossible(0, n, color,adj,4);
        return color;
    }
}