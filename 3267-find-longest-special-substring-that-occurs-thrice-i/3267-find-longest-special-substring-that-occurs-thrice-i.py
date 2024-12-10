class Solution:
    def maximumLength(self, s: str) -> int:

        hashMap = defaultdict(int)
        size = len(s)
        answer = -1
        maxlen = -1

        def isSpecial(string):
            for i in range(1, len(string)):
                if string[i] != string[i - 1]:
                    return False
            return True
        
        for i in range(size):
            for j in range(i,size):
                hashMap[s[i : j + 1]] += 1

        for substring, count in hashMap.items():
            if isSpecial(substring) and count >= 3:
                if len(substring) > maxlen:
                    maxlen = len(substring)
                    answer = count
        return maxlen

        