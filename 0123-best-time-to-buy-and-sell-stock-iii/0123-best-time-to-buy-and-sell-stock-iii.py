class Solution:
    def maxProfit(self, profit: List[int]) -> int:
        size = len(profit)
        dp= [[[-1 for transaction in range(3)] for canBuy in range(2)] for index in range(size)]
        def getMaxprofit(index, canBuy, transactionNumber):
            # Base case
            if index == size or transactionNumber == 0:
                return 0
            if dp[index][canBuy][transactionNumber] != -1:
                return dp[index][canBuy][transactionNumber]
            maxProfit = 0
            if canBuy:
                will_buy = -profit[index] + getMaxprofit(index + 1, 1 - canBuy, transactionNumber)
                will_not_buy = 0 + getMaxprofit(index + 1, canBuy, transactionNumber)
                maxProfit = max(will_buy, will_not_buy)
            else:
                will_sell = profit[index] +  getMaxprofit(index + 1, 1 - canBuy, transactionNumber - 1)
                will_not_sell = getMaxprofit(index + 1, canBuy, transactionNumber)
                maxProfit = max(will_sell, will_not_sell)
            dp[index][canBuy][transactionNumber] = maxProfit
            return dp[index][canBuy][transactionNumber]
        
        # initial index is set to 0
        index = 0
        # initially we can buy so canBuy is set to 1
        canBuy = 1
        # atMax transaction we can do 2 so we will set a counter of two
        transactionNumber = 2

        getMaxProfit = getMaxprofit(index, canBuy, transactionNumber)
        return getMaxProfit