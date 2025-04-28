class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result = 0;
        int i = 0, j = 0, size = nums.length;
        long sum = 0;
        while(j < size){
            sum += nums[j];
            while((j - i + 1) * sum >= k){
                sum -= nums[i];
                i++;
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }
}