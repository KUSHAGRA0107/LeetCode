class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] == 1){
                int index = i + 1;
                for(int j = index; j < min((int) nums.size(), index + k); j++){
                    if(nums[j] == 1 && j - i <= k) return false;
                }
                i = i + k;
            }
        }
        return true;
    }
};