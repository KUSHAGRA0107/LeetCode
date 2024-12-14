class Solution:
    def continuousSubarrays(self, nums: List[int]) -> int:
        min_heap = [] # To store minelement of the current sliding window
        max_heap = [] # To store maxelement of the current sliding window
        answer_count = 0 # To store the answer of the number of window
        size_of_array = len(nums) # variable to store size of array
        left, right = 0,0 # start and end of window

        while right < size_of_array:
            heapq.heappush(min_heap, (nums[right],right))
            heapq.heappush(max_heap, (-nums[right],right))
            # if my condition fails
            while left < right and -max_heap[0][0] - min_heap[0][0] > 2:
                left += 1
                # we will remove all the element on top of min_heap, max_heap
                # which are less than left so that they may not pose any issue

                while min_heap and min_heap[0][1] < left:
                    heapq.heappop(min_heap)
                
                while max_heap and max_heap[0][1] < left:
                    heapq.heappop(max_heap)

            answer_count += right - left + 1
            right += 1

        return answer_count