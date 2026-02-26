class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        string_list = list(s) # To Make string as a mutable object
        while len(string_list) > 1:
            size = len(string_list)

            if string_list[size - 1] == "0":
                string_list.pop()
            else:
                index = len(string_list) - 1

                while index >= 0 and string_list[index] == "1":
                    string_list[index] = "0"
                    index -= 1
                
                if index < 0:
                    string_list.insert(0, "1")
                else:
                    string_list[index] = "1"

            steps += 1
        
        return steps