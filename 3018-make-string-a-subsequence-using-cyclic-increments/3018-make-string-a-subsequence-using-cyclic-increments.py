class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        i,j = 0,0
        size1,size2 = len(str1), len(str2)

        while i < size1 and j < size2:
            if str1[i] == str2[j]:
                i += 1
                j += 1
            elif str1[i] != str2[j]:
                newChar = chr(((ord(str1[i]) + 1 - 97) % 26) + 97)
                if newChar == str2[j]:
                    i += 1
                    j += 1
                else:
                    i += 1
        return j == size2