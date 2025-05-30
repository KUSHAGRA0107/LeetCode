class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int answer = 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(dp.containsKey(num - difference)){
                dp.put(num, dp.get(num - difference) + 1);
            }else{
                dp.put(num, 1);
            }
            answer = Math.max(answer, dp.get(num));
        }
        return answer;
    }
}