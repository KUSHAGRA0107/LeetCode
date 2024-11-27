class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        # First pass solution
        # 1. Traverse if zero than mark first element of the row and column to be zero
        row,col = len(matrix), len(matrix[0])
        check = 1
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0

                    if j != 0:
                        matrix[0][j] = 0
                    else:
                        check = 0

        for i in range(1, row):
            for j in range(1,col):
                if matrix[i][j] != 0:
                    if matrix[i][0] == 0 or matrix[0][j] == 0:
                        matrix[i][j] = 0

        if matrix[0][0] == 0:
            for i in range(col):
                matrix[0][i] = 0
        if check == 0:
            for j in range(row):
                matrix[j][0] = 0
        