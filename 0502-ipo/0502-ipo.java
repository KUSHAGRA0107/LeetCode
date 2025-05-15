class Pair{
    int capital;
    int profit;
    Pair(int capital, int profit){
        this.capital = capital;
        this.profit = profit;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        int size = profits.length;
        for(int i = 0; i < size; i++){
            Pair pair = new Pair(capital[i], profits[i]);
            minHeap.offer(pair);
        }
        for(int i = 0; i < k; i++){
            while(minHeap.size() != 0 && w >= minHeap.peek().capital){
                maxHeap.offer(-minHeap.poll().profit);
            }
            if(maxHeap.size() == 0) break;
            w += -maxHeap.poll();
        }
        return w;
        
    }
}