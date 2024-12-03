class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] table = new int[row][col];
        table[row - 1][col - 1] = grid[row - 1][col - 1];
        for(int column = col - 2; column >= 0; column--){
            table[row - 1][column] = grid[row - 1][column]
            +
            table[row - 1][column + 1];
        }

        for(int i = row - 2; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                int right = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;  

                if(j + 1 < col){
                    right = table[i][j + 1];
                }
                if(i + 1 < row){
                    left = table[i + 1][j];
                }
                table[i][j] = grid[i][j] + Math.min(left, right);
            }
        }
        return table[0][0];
    }
}