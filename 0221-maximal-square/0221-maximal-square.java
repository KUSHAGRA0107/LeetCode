class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] table = new int[m][n];
        int max = 0;
        for(int col = 0; col < n; col++){
            table[0][col] = (matrix[0][col] == '1') ? 1 : 0; 
            max = Math.max(max, table[0][col]);
            }
        for(int row = 0; row < m; row++){
            table[row][0] = (matrix[row][0] == '1') ? 1 : 0;
            max = Math.max(max, table[row][0]);
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    table[i][j] = 1 + Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1]));
                    max = Math.max(max, table[i][j]);
                }
            }
        }
        return max * max;
    }
}