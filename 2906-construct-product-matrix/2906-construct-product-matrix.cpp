class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        vector<vector<int>> resultant(row, vector<int>(col));
        long long prefix = 1, suffix = 1;
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                resultant[i][j] = suffix;
                suffix = (suffix * grid[i][j]) % 12345;
            }
        }
        
        for(int i = 0; i < row ; i++){
            for(int j = 0; j < col; j++){
                resultant[i][j] = (prefix * resultant[i][j]) % 12345;
                prefix = (prefix * grid[i][j]) % 12345;
            }
        }
        return resultant;
    }
};