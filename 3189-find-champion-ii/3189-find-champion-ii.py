class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        indegree_array = [0 for i in range(n)]

        for x,y in edges:
            indegree_array[y] += 1
        winner = -1
        count = 0
        for i in range(len(indegree_array)):
            if indegree_array[i] == 0:
                count += 1
                winner = i

        return -1 if count > 1 else winner