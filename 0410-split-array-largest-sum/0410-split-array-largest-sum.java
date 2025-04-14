class Solution {
    public boolean canSplit(int[] nums, int k, int orgSum){
        int split = 1;
        int sumLeft = 0;
        for(int i = 0; i < nums.length; i++){
            sumLeft += nums[i];
            if(sumLeft > orgSum){
                sumLeft = nums[i];
                split++;
                if(split > k) return false;
            }
        }

        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int answer = -1;
        while(low <= high){
            int orgSum = (low + high)/2;
            if(canSplit(nums,k, orgSum)){
                answer = orgSum;
                high = orgSum - 1;
            }else{
                low = orgSum + 1;
            }
        }
        return answer;
    }
}