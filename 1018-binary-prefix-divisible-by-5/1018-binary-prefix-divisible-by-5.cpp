class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        int value = 0;
        vector<bool> answer(nums.size(), false);
        for(int i = 0; i < nums.size(); i++){
            value = ((value << 1) + nums[i]) % 5 ;
            answer[i] = value == 0;
        }
        return answer;
    }
};
