class Solution {
    public static boolean check(int index, int i, int j, String word, char[][] board, int [][] visited){
        int size = word.length();
        int row = board.length, col = board[0].length;
        if(index == size){
            return true;
        }
        if(i < 0 || i >= row || j < 0 || j >= col){
            return false;
        }
        if(visited[i][j] == 1 || word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = 1;
        boolean left = check(index + 1, i , j - 1, word, board, visited);
        boolean right = check(index + 1, i , j + 1, word, board, visited);
        boolean up = check(index + 1, i - 1 , j, word, board, visited);
        boolean down = check(index + 1, i + 1 , j, word, board, visited);
        visited[i][j] = 0;
        return left || right || up || down;

    }
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int index = 0;
        char ch  = word.charAt(0);
        int [][] visited = new int [row][col];

        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                visited[i][j] = 0;
            
            }
            }

        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == ch){
                    if(check(0,i,j,word,board, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}