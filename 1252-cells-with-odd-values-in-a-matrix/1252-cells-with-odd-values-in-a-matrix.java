class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int [][] result = new int[m][n];
        int answer = 0;
        for(int i = 0; i < m; i++) Arrays.fill(result[i], 0);
        for(int i = 0; i < indices.length; i++){
            int row = indices[i][0], col = indices[i][1];
            for(int x = 0; x < n; x++) result[row][x]++;
            for(int x = 0; x < m; x++) result[x][col]++;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(result[i][j] % 2 == 1) answer++;
            }
        }
        return answer;
    }
}