class Solution:
    def minOperations(self, s: str) -> int:
        size = len(s)
        list1 = []
        list2 = []
        flag1 = 0
        flag2 = 1
        string_list = list(s)

        for index in range(size):
            list1.append(flag1)
            list2.append(flag2)
            flag1 = 1 - flag1 
            flag2 = 1 - flag2

        counter1 = counter2 = 0

        for index in range(size):
            counter1 += int (string_list[index]) ^ list1[index]
            counter2 += int (string_list[index]) ^ list2[index]
        
        return min(counter1, counter2)