class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        frequency_array = [0 for i in range(max(nums) + 1)]
        answer = 0
        for i in nums:
            frequency_array[i] += 1
        maxi = -1
        for i in frequency_array:
            if maxi < i:
                maxi = i
        for i in frequency_array:
            if maxi == i:
                answer += i
        # print(frequency_array)
        return answer
            