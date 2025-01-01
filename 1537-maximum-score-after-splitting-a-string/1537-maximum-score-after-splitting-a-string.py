class Solution:
    def maxScore(self, s: str) -> int:
        total_zero = 0
        total_one = 0
        maxi = 0
        for i in s:
            if i == "0":
                total_zero += 1
            else:
                total_one += 1
            
        left_zero, left_one = 0,0

        for i in range(len(s) - 1):
            if s[i] == "0":
                left_zero += 1
            else:
                left_one += 1
            maxi  = max(maxi , left_zero + total_one - left_one)

        return maxi