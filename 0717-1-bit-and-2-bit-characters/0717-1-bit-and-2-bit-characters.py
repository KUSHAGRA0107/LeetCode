class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        index = 0
        size = len(bits)

        while True:
            if index == size:
                return False
            if index == size - 1:
                return True
            if bits[index] == 1:
                index += 2
            else:
                index += 1
        return False