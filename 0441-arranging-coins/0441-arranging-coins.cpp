class Solution {
public:
    int arrangeCoins(int n) {
        int current_row = 1;
        int next_row = n;
        int stairs = 0;
        while(current_row <= next_row){
            stairs++;
            next_row -= current_row;
            current_row++;
        }
        return stairs;
    }
};