class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        size = len(nums)
        total_string = pow(2, len(nums[0]))
        decimalList = set()

        def converttoDecimal(s):
            decimal = 0

            for bit in s:
                decimal = decimal * 2 + int(bit)
            return decimal
        
        def toBinary(number):
            answer = ""
            while number:
                answer += str(number % 2)
                number = number // 2
            return answer[::-1].zfill(size)

        for i in range(size):
            getNumber = converttoDecimal(nums[i])
            decimalList.add(getNumber)

        print(decimalList)

        for i in range(total_string):
            if i not in decimalList:
                return toBinary(i)
        return ""
        