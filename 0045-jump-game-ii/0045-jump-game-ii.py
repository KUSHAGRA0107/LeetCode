class Solution:
    def jump(self, nums: List[int]) -> int:
        size = len(nums)
        dp = [-1 for i in range(size)]
        def helper(index):
            if index >= size - 1:
                return 0
            if dp[index] != -1:
                return dp[index]
            min_answer = size + 1

            for i in range(nums[index], 0, -1):
                jumps = 1 + helper(index + i)
                min_answer = min(min_answer, jumps)
            dp[index] = min_answer
            return min_answer
        answer = helper(0)
        return answer