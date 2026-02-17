class Solution {
    public void dfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adjacentList){
        visited[node] = true;
        for(int adjacentNode : adjacentList.get(node)){
            if(!visited[adjacentNode]) dfs(adjacentNode, visited, adjacentList);
        }
        return;
    }
    public int makeConnected(int n, int[][] connections) {
       int size = connections.length;
       if(size < n - 1) return -1;
       
       ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<>();
       int connectedComponent = 0;
       boolean [] visited = new boolean[n];
       Arrays.fill(visited, false);

       for(int i = 0; i < n; i++) adjacentList.add(new ArrayList<> ());

       for(int i = 0; i < size; i++){
        int u = connections[i][0], v = connections[i][1];
        adjacentList.get(u).add(v);
        adjacentList.get(v).add(u);       
       }
       
        
       for(int node = 0; node < n; node++){
        if(!visited[node]){
            connectedComponent++;
            dfs(node, visited, adjacentList);
        }
       }
       
       return connectedComponent - 1;
    }
}

/*  1. The Idea is To make A spanning tree that for n nodes requires n - 1 edges
connections tell the edges and if we have atleast n - 1 edges then we can surely
create our desired structure,
After checking the condition mentioned above we just need to calculate the number of connected component suppose 'x' then 'x - 1' will be our output
else -1 if condition 1 fails*/