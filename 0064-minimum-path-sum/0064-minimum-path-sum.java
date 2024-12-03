class Solution {
    public int getminSum(int i, int j, int [][] grid, int [][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || j >= n || i >= m){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == m - 1 && j == n - 1){
            return grid[m - 1][n - 1];
        }
        int right = getminSum(i, j + 1, grid,dp);
        int down = getminSum(i + 1, j,grid,dp);
        dp[i][j] =  grid[i][j] + Math.min(right, down);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j < grid[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return getminSum(0,0,grid,dp);
    }
}