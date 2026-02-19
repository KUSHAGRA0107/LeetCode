class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length, col = mat[0].length;
        if(row * col != r * c) return mat;
        int [] temp = new int[row * col];
        int index = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                temp[index++] = mat[i][j];
            }
        }  
        int [][] resultant = new int[r][c];
        for(int i = 0; i < temp.length; i++) {
            resultant[i / c][i % c] = temp[i];
        }       
        return resultant;
    }
}