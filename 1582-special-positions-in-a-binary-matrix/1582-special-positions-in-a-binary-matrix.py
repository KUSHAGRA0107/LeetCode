class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        special_position = 0
        row, col = len(mat), len(mat[0])

        def checkRow(rowNo, colNo):
            for i in range(col):
                if mat[rowNo][i] == 1 and i != colNo:
                    return False
            return True

        def checkCol(rowNo, colNo):
            for i in range(row):
                if mat[i][colNo] == 1 and i != rowNo:
                    return False
            return True


        for i in range(row):
            for j in range(col):
                if mat[i][j] == 1:
                    if checkRow(i, j) and checkCol(i, j):
                        special_position += 1
        
        return special_position