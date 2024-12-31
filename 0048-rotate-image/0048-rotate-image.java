class Solution {
    public static void reverse(int [] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 1;
            j -= 1;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose of the Matrix
        for(int i = 0; i < n - 1;i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse the matrix row-wise
        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }
    }
}