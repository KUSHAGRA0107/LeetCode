class Solution:
    def minArraySum(self, nums: List[int], k: int, op1: int, op2: int) -> int:
        size  = len(nums)
        dp = [[[-1 for i in range(op2 + 1)] for j in range(op1 + 1)] for k in range(size)]

        def helper(index, op1, op2):
            if index == size:
                return 0
            if dp[index][op1][op2] != -1:
                return dp[index][op1][op2]
            answer =  nums[index] + helper(index + 1, op1, op2)
            if op1 > 0:
                operation = (nums[index] + 1)//2 + helper(index + 1, op1 - 1, op2)
                answer = min(answer, operation)
            if op2 > 0 and nums[index] >= k:
                operation = nums[index] - k + helper(index + 1,op1, op2 - 1)
                answer = min(answer, operation)
            if op1 != 0 and op2 != 0:
                operation1 = (nums[index] + 1)//2
                if operation1 >= k:
                    answer = min(answer, operation1 - k + helper(index + 1, op1 - 1, op2 - 1))
                if nums[index] >= k:
                    answer = min(answer,((nums[index]-k) + 1)//2 + helper(index + 1, op1 - 1, op2 - 1))
        
            dp[index][op1][op2] = answer
            return dp[index][op1][op2]
        
        answer = helper(0,op1,op2)
        return answer