class Solution {
    public boolean helper(int [] candies, long k , int candy){
        long counter = 0;
        for(int i = 0; i < candies.length; i++){
            counter += candies[i] / candy;
        }
        return counter >= k;
    }
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = Arrays.stream(candies).max().getAsInt();
        int answer = 0;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(helper(candies, k, mid)){
                answer = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return answer;
    }
}