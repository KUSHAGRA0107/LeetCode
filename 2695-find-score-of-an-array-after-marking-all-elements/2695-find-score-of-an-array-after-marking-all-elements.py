class Solution:
    def findScore(self, nums: List[int]) -> int:
        min_heap = []
        for i in range(len(nums)):
            heapq.heappush(min_heap,(nums[i],i))
        exempted_set = set()
        answer = 0
        while min_heap:
            element, index = heapq.heappop(min_heap)
            if index not in exempted_set:
                exempted_set.add(index)
                answer += element
                if index - 1 >= 0:
                    exempted_set.add(index - 1)
                if index + 1 < len(nums):
                    exempted_set.add(index + 1)
        return answer