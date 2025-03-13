class Solution {
    public boolean helper(int [] nums, int [][] queries, int k){
        int [] difference = new int[nums.length + 1];
        int sum = 0;
        for(int i = 0; i < k; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];
            difference[left] += value;
            difference[right + 1] -= value;
        }
        for(int i = 0;i < nums.length; i++){
            sum += difference[i];
            if(sum < nums[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int low = 0;
        int high = queries.length - 1;
        if(helper(nums, queries, high + 1) == false) return -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(helper(nums, queries, mid) == true){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}