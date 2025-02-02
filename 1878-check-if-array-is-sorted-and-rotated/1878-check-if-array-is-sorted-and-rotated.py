class Solution:
    def check(self, nums: List[int]) -> bool:
        peakElement = 0
        n = len(nums)
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                peakElement += 1
        if nums[0] < nums[n-1]:
            peakElement += 1
        return peakElement <= 1