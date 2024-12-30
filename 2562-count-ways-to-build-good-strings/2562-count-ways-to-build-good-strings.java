class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int [] dp_table = new int[high + 1];
        dp_table[high] = 0;
        int result = 0;
        int mod = 1000000007;

        for(int i = high; i >= 0; i--){
            result = 0;
            if(low <= i && i <= high) result = 1;
            if(i + zero <= high) result += dp_table[i + zero];
            if(i + one <= high) result += dp_table[i + one];
            dp_table[i] = result % mod;
        }
        return dp_table[0];
    }
}