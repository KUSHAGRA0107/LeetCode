class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def build(n):
            if n == 1:
                return "0"
            prev = build(n - 1)
            inverted = ''.join('1' if c == '0' else '0' for c in prev)
            
            return prev + "1" + inverted[::-1]
        string = build(n)
        return string[k - 1]