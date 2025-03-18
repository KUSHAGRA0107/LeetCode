class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        table = [-1 for i in range(len(matrix[0]))]
        table = matrix[0]

        for i in range(1,len(matrix)):
            temp_arr = [0 for i in range(len(matrix[0]))]
            for j in range(len(matrix[0])):
                x1,x2,x3 = [float('inf') for i in range(3)]
                if j - 1 >= 0:
                    x1 = matrix[i][j] + table[j - 1]
                x2 = matrix[i][j] + table[j]
                if j + 1 < len(matrix[0]):
                    x3 = matrix[i][j] + table[j + 1]
                answer = min(x1,x2,x3)
                temp_arr[j] = answer
            table = temp_arr
        return min(table)