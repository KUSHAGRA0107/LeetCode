class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        def reverse(string):
            return string[::-1]

        def invert(s):
            list1 = list(s)
            size = len(s)
            for i in range(size):
                if s[i] == "1":
                    list1[i] = "0"
                else:
                    list1[i] = "1"
            answer = ""
            for i in list1:
                answer += i

            return answer

        def formString(n):
            if n == 1:
                return "0"
            else:
                string = formString(n - 1)
                return  string + "1" + reverse(invert(string))

        string = formString(n)
        return string[k - 1]