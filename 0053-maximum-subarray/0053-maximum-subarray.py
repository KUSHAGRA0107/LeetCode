class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxi_sum = float('-inf')
        curr_sum = 0
        size = len(nums)

        for i in range(size):
            curr_sum += nums[i]
            if curr_sum > maxi_sum:
                maxi_sum = curr_sum
            if curr_sum < 0:
                curr_sum = 0
        
        return maxi_sum