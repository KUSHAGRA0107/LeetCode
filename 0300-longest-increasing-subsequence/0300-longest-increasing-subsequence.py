class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        dp = [[-1 for j in range(size)] for k in range(size + 1)]
        
        def getMaxtime(previous, index):
            if index == size:
                return 0
            if dp[previous][index] != -1:
                return dp[previous][index]
            value = getMaxtime(previous, index + 1)

            if previous == -1 or nums[index] > nums[previous]:
                value = max(value, 1 + getMaxtime(index, index + 1))
            
            dp[previous][index] = value
            return dp[previous][index]
        

        return getMaxtime(-1, 0)