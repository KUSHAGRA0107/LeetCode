class Solution {
    public:
        long long minimalKSum(vector<int>& nums, int k) {
                sort(nums.begin() , nums.end());
                        long long res = 1LL * k * (k + 1) / 2;
                                if(nums[0] <= k) res += ++k - nums[0];
                                        for(int i = 1, n = nums.size(); i < n && nums[i] <= k; ++i){
                                                    if(nums[i] != nums[i - 1]) res += ++k - nums[i];
                                                            }
                                                                    return res;
                                                                        }
                                                                        };
