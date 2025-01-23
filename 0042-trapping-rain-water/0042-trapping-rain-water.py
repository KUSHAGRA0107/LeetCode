class Solution:
    def trap(self, height: List[int]) -> int:
        size = len(height)
        leftmax_array, rightmax_array = [0] * size, [0] * size
        leftmax_array[0] = height[0]
        for i in range(1,size):
            leftmax_array[i] = max(leftmax_array[i-1],height[i])
        rightmax_array[size - 1] = height[size - 1]
        for i in range(size - 2,0,-1):
            rightmax_array[i] = max(rightmax_array[i + 1],height[i])
        value = 0
        count = 0
        for i in range(size):
            if i == 0 or i == size - 1:
                continue
            value = min(leftmax_array[i - 1],rightmax_array[i + 1])
            if value >= height[i]:
                count += (value - height[i])    

        return count
