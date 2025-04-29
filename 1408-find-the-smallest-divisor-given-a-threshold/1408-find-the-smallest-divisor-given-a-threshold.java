class Solution {
    public boolean canDivide(int [] nums, int threshold, int divisor){
        int answer = 0;
        for(int i : nums){
            answer += Math.ceil((double)(i) / (double)(divisor));
        }
        return answer <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int answer = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canDivide(nums, threshold, mid)){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}