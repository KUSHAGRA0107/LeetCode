class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        int maxi = 0;
        for(int i = 0; i < nums.size(); i++){
            maxi = max(maxi,nums[i]);
        }
        vector<int> frequency(maxi + 1, 0);
        for(int i = 0; i < nums.size(); i++){
            frequency[nums[i]] += 1;
            if(frequency[nums[i]] > 1) return nums[i];
        }  
        return 0;
    }
};