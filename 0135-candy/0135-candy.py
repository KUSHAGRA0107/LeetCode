class Solution:
    def candy(self, ratings: List[int]) -> int:
        size = len(ratings)
        left_arr = [0 for i in range(size)]
        right_arr = [0 for i in range(size)]
        left_arr[0] = 1
        right_arr[-1] = 1
        total_answer = 0

        for i in range(1,size):
            if ratings[i] > ratings[i - 1]:
                left_arr[i] = left_arr[i - 1] + 1
            else:
                left_arr[i] = 1

        for i in range(size - 2,-1,-1):
            if ratings[i] > ratings[i + 1]:
                right_arr[i] = right_arr[i + 1] + 1
            else:
                right_arr[i] = 1

        for i in range(size):
            total_answer += max(left_arr[i], right_arr[i])
        
        return total_answer