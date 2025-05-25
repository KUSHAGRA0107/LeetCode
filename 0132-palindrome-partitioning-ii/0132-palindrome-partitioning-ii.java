class Solution {
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    public int minCut(String s) {
        int size = s.length() + 1;
        int [] dp = new int[size];
        dp[size - 1] = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(i, j, s)){
                    int cost = 1 + dp[j + 1];
                    min = Math.min(cost, min);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }
}