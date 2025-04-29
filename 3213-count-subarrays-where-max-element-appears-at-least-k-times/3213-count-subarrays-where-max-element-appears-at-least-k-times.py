class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        element = max(nums)
        count = 0
        i,j = 0,0
        answer = 0
        while j < len(nums):
            if nums[j] == element:
                count += 1
                
            if count >= k:
                while count >= k:
                    answer += len(nums) - j
                    if nums[i] == element:
                        count -= 1
                    i += 1
            j += 1
        return answer