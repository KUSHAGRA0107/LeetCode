class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        size = len(prices)
        dp = [[[-1 for i in range(k + 1)] for j in range(2)] for x in range(size)]

        def getMaxprofit(index, canBuy, txnValue):

            if index == size or txnValue == 0:
                return 0
            
            max_profit = 0
            if dp[index][canBuy][txnValue] != -1:
                return dp[index][canBuy][txnValue]

            if canBuy:
                can_buy = -prices[index] + getMaxprofit(index + 1, 1 - canBuy, txnValue)
                cannot_buy = getMaxprofit(index + 1, canBuy, txnValue)
                max_profit = max(can_buy, cannot_buy)
            else:
                can_sell = prices[index] + getMaxprofit(index + 1, 1 - canBuy, txnValue - 1)
                cannot_sell = getMaxprofit(index + 1, canBuy, txnValue)
                max_profit = max(can_sell, cannot_sell)

            dp[index][canBuy][txnValue] = max_profit
            return dp[index][canBuy][txnValue] 
        answer = getMaxprofit(0, 1, k)
        return answer
