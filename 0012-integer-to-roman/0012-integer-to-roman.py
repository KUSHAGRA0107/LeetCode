class Solution:
    def intToRoman(self, num: int) -> str:
        answer = ""
        myList = [["M", 1000], ["CM", 900],["D", 500],
            ["CD", 400],["C", 100],["XC", 90],
            ["L", 50],["XL", 40],["X", 10],
            ["IX", 9],["V", 5], ["IV", 4],["I", 1]]
        index = 0

        while num:
            if num // myList[index][1]:
                count = num // myList[index][1] 
                answer += count * myList[index][0]
            num = num % myList[index][1]
            index += 1

        return answer