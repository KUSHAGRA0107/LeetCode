class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        def helper():
            for i in range(len(mat) - 1):
                for j in range(i + 1, len(mat)):
                    mat[i][j], mat[j][i] = mat[j][i],mat[i][j]
            for i in range(len(mat)):
                start, end = 0, len(mat[i]) - 1
                while start < end:
                    mat[i][start], mat[i][end] = mat[i][end], mat[i][start]
                    start += 1
                    end -= 1
            for i in range(len(mat)):
                for j in range(len(mat)):
                    if mat[i][j] != target[i][j]:
                        return False
            return True
        for i in range(4):
            if helper():
                return True
        return False  
