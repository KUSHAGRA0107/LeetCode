class Solution {
    public int findKthPositive(int[] arr, int k) {
        int size = arr.length;
        int low = 0, high = size - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] - (mid + 1) >= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low + k;
    }
}