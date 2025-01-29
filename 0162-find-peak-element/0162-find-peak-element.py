class Solution:
    def findPeakElement(self, arr: List[int]) -> int:
        if len(arr) == 1 or arr[0] > arr[1]:
            return 0
        if arr[-1] > arr[-2]:
            return len(arr) - 1
        low = 1
        high = len(arr) - 2

        while low <= high:
            mid = (low + high) >> 1
            if arr[mid - 1] < arr[mid] > arr[mid + 1]:
                return mid
            elif arr[mid] < arr[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        return 0

        