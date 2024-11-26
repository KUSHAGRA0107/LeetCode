from typing import List

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        pascalTriangle = []

        # Construct each row one by one
        for i in range(numRows):
            row = [1] * (i + 1)  # Every row starts with 1's
            
            # Update the internal values for the row
            for j in range(1, i):
                row[j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]
                
            pascalTriangle.append(row)

        return pascalTriangle
