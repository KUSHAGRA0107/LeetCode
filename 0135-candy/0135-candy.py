class Solution:
    def candy(self, ratings: List[int]) -> int:
        size = len(ratings)
        left_arr = [0 for i in range(size)]
        left_arr[0] = 1
        total_answer = 0
        right,curr = 1,0
        for i in range(1,size):
            if ratings[i] > ratings[i - 1]:
                left_arr[i] = left_arr[i - 1] + 1
            else:
                left_arr[i] = 1

        for i in range(size - 2,-1,-1):
            if ratings[i] > ratings[i + 1]:
                curr = right + 1
            else:
                curr = 1
            total_answer += max(curr,left_arr[i])
            right = curr
        total_answer += max(1,left_arr[-1])
        return total_answer