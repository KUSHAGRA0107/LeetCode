class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        dp = [[0,0] for i in range(len(prices) + 1)]
        size = len(prices)
        for i in range(size - 1, -1, -1):
            max_profit = 0

            for canBuy in range(2):
                if canBuy:
                    take = -prices[i] + dp[i + 1][1 - canBuy]
                    not_take = dp[i + 1][canBuy]
                    max_profit = max(take, not_take)
                else:
                    take = (prices[i] - fee) + dp[i + 1][1 - canBuy]
                    not_take = dp[i + 1][canBuy]
                    max_profit = max(take, not_take)
                dp[i][canBuy] = max_profit
        return dp[0][1]
