class Solution {
    public int trailingZeroes(int n) {
        int number = 5;
        int count = 0;
        while(n >= number){
            count += Math.floor(n/number);
            n = n/number;
        }
        return count;
    }
}