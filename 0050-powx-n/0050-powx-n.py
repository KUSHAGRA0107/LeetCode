class Solution:
    def pow(self,x,n):
        if n == 0:
            return x
        carry = 1
        left = pow(x,n//2)
        right = pow(x,n//2)
        if n % 2 !=0:
            carry = x
        return left * right * ans

    def myPow(self, x: float, n: int) -> float:
        # temp = 0
        # infinity = [-2147483648,2147483648]
        # if n in infinity:
        #     if x in [0,1,-1]:
        #         return x
        #     return 0
        if n < 0:
            x = 1/x
            n = -n
        ans = pow(x,n)
        # if temp == 1:
        #     ans = 1/ans
        return ans