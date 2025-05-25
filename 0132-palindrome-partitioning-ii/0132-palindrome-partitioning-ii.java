class Solution {
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    public int getMinPartition(int index, int n, String s, int [] dp){
        if(index == n) return 0;
        if(dp[index] != -1) return dp[index];
        int answer = s.length() + 1;
        for(int j = index; j < n; j++){
            if(isPalindrome(index, j, s)){
                answer = Math.min(answer, 1 + getMinPartition(j + 1, n, s, dp));
            }
        }
        return dp[index] = answer;
    }
    public int minCut(String s) {
        int [] dp = new int[s.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp, -1);
        int answer = getMinPartition(0, s.length(), s, dp);
        return answer - 1;
    }
}