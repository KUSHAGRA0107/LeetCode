class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        set<int>s;
        for(int i = 0; i < nums.size(); i++) s.insert(nums[i]);
        while(s.contains(original)) original = original * 2;
        return original;
    }
};