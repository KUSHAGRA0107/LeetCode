class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        frequency = [0] * (max(nums) + 1)
        for i in range(len(nums)):
            frequency[nums[i]] += 1
        heap = []
        for i in range(len(frequency)):
            heapq.heappush(heap,(-frequency[i],i))
        max_element = heap[0][0]
        cnt = 0
        while len(heap) != 0:
            if max_element == heap[0][0]:
                cnt += (-heap[0][0])
                heapq.heappop(heap)
            else:
                return cnt
        return -1