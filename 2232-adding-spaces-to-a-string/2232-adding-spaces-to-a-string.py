class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        resultantString = ""
        size = len(s)
        spaces = set(spaces)

        for index in range(size):
            if index in spaces:
                resultantString += " "
            resultantString += s[index]
        
        return resultantString
