class Solution {
    public static boolean binarySearch(int start, int end, ArrayList<Integer> breakPoint){
        int low = 0;
        int high = breakPoint.size() - 1;
        int mid = 0;

        while(low <= high){
            mid = (low + high) >> 1;
            if(breakPoint.get(mid) < start){
                low = mid + 1;
            }
            else if(breakPoint.get(mid) > end){
                high = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        ArrayList<Integer> breakPoint = new ArrayList<>();
        boolean [] answer = new boolean[queries.length];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] % 2 == nums[i - 1] % 2){
                breakPoint.add(i);
            }
        }   

        for(int i = 0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];

            boolean isViolating = binarySearch(start + 1, end, breakPoint);
            if(isViolating){
                answer[i] = false;
            }
            else{
                answer[i] = true;
            }
        }

        return answer;
    }
}