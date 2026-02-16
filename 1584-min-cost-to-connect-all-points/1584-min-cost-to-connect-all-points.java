class Pair{
    int edgeCost;
    int nodeNumber;
    Pair(int edge, int node){
        edgeCost = edge;
        nodeNumber = node;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        int minimumCost = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x, y) -> x.edgeCost - y.edgeCost);
        ArrayList<ArrayList<int []>> adjacencyList = new ArrayList<>();
        boolean [] visited = new boolean[size];
        Arrays.fill(visited, false);
        for(int i = 0; i < size; i++){
            adjacencyList.add(new ArrayList<>());
        }

        /*Time Complexity : O(V * V) */
        for(int node = 0; node < size; node++){
            for(int i = 0; i < size; i++){
                if(i != node){
                    int distance = Math.abs(points[node][0] - points[i][0]) +  Math.abs(points[node][1] - points[i][1]);
                    adjacencyList.get(node).add(new int[]{i, distance});
                }
            }
        }

        minHeap.offer(new Pair(0,0));

        /* Worst Case At Max E Edges Can be there in MinHeap and For Each Operation LOG E Time i.e ELOGE*/
        while(minHeap.size() != 0){
            int edgeCost = minHeap.peek().edgeCost, nodeNumber = minHeap.peek().nodeNumber;
            minHeap.poll();

            if(visited[nodeNumber] == true) continue;
            minimumCost += edgeCost;
            visited[nodeNumber] = true;
            ArrayList<int[]> adjacent = adjacencyList.get(nodeNumber);
            for(int i = 0; i < adjacent.size(); i++){
                int node = adjacent.get(i)[0];
                int cost = adjacent.get(i)[1];
                minHeap.offer(new Pair(cost, node));
            }

        }
        return minimumCost;
    }
}