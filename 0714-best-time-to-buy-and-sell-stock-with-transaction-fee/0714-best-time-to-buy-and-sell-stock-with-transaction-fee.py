class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        size = len(prices)
        dp = [[-1,-1] for i in range(size)]
        def helper(index, canBuy):
            if index == size:
                return 0
            max_profit = 0
            if dp[index][canBuy] != -1:
                return dp[index][canBuy]
            if canBuy:
                can_buy = -prices[index] + helper(index + 1,1 - canBuy)
                cannot_buy = helper(index + 1,canBuy)
                max_profit = max(can_buy, cannot_buy)
            else:
                can_sell = (prices[index] - fee) + helper(index + 1,1 - canBuy)
                cannot_sell = helper(index + 1,canBuy)
                max_profit = max(can_sell, cannot_sell)
            dp[index][canBuy] = max_profit
            return dp[index][canBuy]

        answer = helper(0, 1)
        return answer




