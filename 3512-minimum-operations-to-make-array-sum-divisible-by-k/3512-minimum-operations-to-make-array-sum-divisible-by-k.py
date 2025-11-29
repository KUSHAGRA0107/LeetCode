class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        getSum = sum(nums)
        remainder = getSum % k
        return remainder