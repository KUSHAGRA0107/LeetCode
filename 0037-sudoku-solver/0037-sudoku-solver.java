class Solution {
    public boolean isValidPlacement(int row, int col, char [][] board, char ch){
        /*Checking the current row */
        for(int i = 0; i < 9; i++){
            if(board[row][i] == ch) return false;
        }
        /*Checking the current row */
        for(int i = 0; i < 9; i++){
            if(board[i][col] == ch) return false;
        }

        /*Checking the current grid*/
        int row_idx = 3 * (row / 3);
        int col_idx = 3 * (col / 3);
        for(int r = row_idx; r < row_idx + 3; r++){
            for(int c = col_idx; c < col_idx + 3; c++){
                if(board[r][c] == ch) return false;
            }
        }
        return true;

    }
    public boolean solve(int row, int col, char [][] board){
        if(row == 9) return true;
        if(col == 9) return solve(row + 1, 0, board);
        if(board[row][col] != '.') return solve(row, col + 1, board);
        for(char ch = '1'; ch <= '9'; ch++){
            if(isValidPlacement(row, col, board, ch)){
                board[row][col] = ch;
                if(solve(row, col + 1, board) == true){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }
}