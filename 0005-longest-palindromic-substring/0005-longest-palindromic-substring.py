class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxLen = 1
        start = 0
        size = len(s)

        for i in range(size):
            for j in range(2):
                low = i 
                high = i + j

                while low >= 0 and high < size and s[low] == s[high]:
                    sizeP = high - low + 1
                    if sizeP > maxLen:
                        maxLen = sizeP
                        start = low
                    low -= 1
                    high += 1
        return s[start : start + maxLen]