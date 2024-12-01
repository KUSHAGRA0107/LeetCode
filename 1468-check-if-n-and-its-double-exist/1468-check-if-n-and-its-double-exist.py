class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        hashMap = {}

        for i in range(len(arr)):
            if 2 * arr[i] in hashMap:
                return True
            if arr[i] % 2 == 0:
                if arr[i]//2 in hashMap:
                    return True
            hashMap[arr[i]] = 1
        return False