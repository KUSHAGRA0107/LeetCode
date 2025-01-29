from collections import defaultdict 
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        map = defaultdict(int)
        count = 0
        preSum = 0
        map[0] = 1
        for i in range(len(nums)):
            preSum += nums[i]
            remove = preSum - k
            count += map[remove]
            map[preSum] += 1
        return count

