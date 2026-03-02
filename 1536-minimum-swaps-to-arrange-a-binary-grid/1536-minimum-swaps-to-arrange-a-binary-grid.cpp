class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int size = grid.size();
        int answer = 0;
        vector<int> position(size, -1);
        for(int i = 0; i < size; i++){
            for(int j = size - 1; j >= 0; j--){
                if(grid[i][j] == 1) {
                    position[i] = j; break;
                }
            }
        }

        for(int i = 0; i < size; i++){
            int index = -1;
            for(int j = i; j < size; j++){
                if(position[j] <= i){
                    answer += j - i;
                    index = j;
                    break;
                }
            }
            if(index >= 0){
                for(int j = index; j > i; j--){
                    swap(position[j], position[j - 1]);
                }
            }else{
                return -1;
            }

        }
        return answer;
    }
};