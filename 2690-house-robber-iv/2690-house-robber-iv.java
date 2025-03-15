class Solution {
    public int minCapability(int[] nums, int k) {
        int answer = 0;
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        while(low <= high){
            int mid = (low + high) >> 1;
            int counter = 0;
            for(int index = 0; index < nums.length; index++){
                if(nums[index] <= mid){
                    counter++;
                    index++;
                }
            }
            if(counter >= k){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
}