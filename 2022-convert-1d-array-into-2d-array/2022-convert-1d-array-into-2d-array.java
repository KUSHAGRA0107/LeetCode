class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int size = m * n;
        if(original.length != size) return new int[0][0];
        int [][] resultant = new int[m][n];
        for(int i = 0; i < original.length; i++){
            resultant[i / n][i % n] = original[i];
        }
        return resultant;
    }
}