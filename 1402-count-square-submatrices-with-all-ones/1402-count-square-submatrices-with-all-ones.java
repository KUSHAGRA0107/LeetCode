class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] table = new int[n][m];
        int answer = 0;
        for(int i = 0; i<n; i++){
            table[i][0] = matrix[i][0];
            answer += matrix[i][0];
        }
        for(int i = 1; i<m; i++){
            table[0][i] = matrix[0][i];
            answer += matrix[0][i];
            }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 1){
                    int left = table[i][j - 1];
                    int up = table[i - 1][j];
                    int diagonal = table[i - 1][j - 1];
                    table[i][j] = 1 + Math.min(left, Math.min(up, diagonal));
                    answer += table[i][j];
            }
        }}
        return answer;
    }
}