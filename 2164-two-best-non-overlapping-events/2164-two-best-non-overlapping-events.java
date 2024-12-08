class Solution {
    public int maxTwoEvents(int[][] events) {
        int size = events.length;
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        int low,mid,high;
        int start,end,value;
        int [] suffix = new int[size];
        suffix[size - 1] = events[size - 1][2];
        int maxSum = 0;
        for(int i = size - 2; i >= 0; i--){
            suffix[i] = Math.max(events[i][2], suffix[i + 1]);
        }

        for(int i = 0; i < size; i++){
            start = events[i][0];
            end = events[i][1];
            value = events[i][2];
            low = i + 1;
            mid = 0;
            high = size - 1;
            int target = -1;
            while(low <= high){
                mid = (low + high) >> 1;

                if(events[mid][0] > end){
                    high = mid - 1;
                    target = mid;
                }
                else{
                    low = mid + 1;
                }
            }
            if(target != -1){
                maxSum = Math.max(maxSum, value + suffix[target]);
            }
                maxSum = Math.max(maxSum, value);
        }
        return maxSum;
    }
}