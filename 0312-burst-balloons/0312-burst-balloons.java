class Solution {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int [] temp = new int[size + 2];
        for(int i = 0; i < size; i++)temp[i + 1] = nums[i];
        temp[0] = 1;
        temp[size + 1] = 1;
        int [][] table = new int[size + 2][size + 2];
        for(int i = size ; i > 0; i--){
            for(int j = 0; j <= size; j++){
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int index = i; index <= j; index++){
                    maxi = Math.max(maxi, temp[i - 1] * temp[index] * temp[j + 1] + table[i][index - 1] +
                    table[index + 1][j]);
                }
                table[i][j] = maxi;
            }
        }
        return table[1][size];
    }
}