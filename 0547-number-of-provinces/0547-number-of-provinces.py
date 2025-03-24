class Solution:
    def dfs(self,node,adjacency_list,visited_array):
        visited_array[node] = True
        for i in adjacency_list[node]:
            if visited_array[i] == False:
                self.dfs(i,adjacency_list,visited_array)

    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        adjacency_list = [[] for _ in range(len(isConnected))]
        for i in range(len(isConnected)):
            for j in range(len(isConnected)):
                if isConnected[i][j] == 1 and i != j:
                    adjacency_list[i].append(j)
                    adjacency_list[j].append(i)
        print(adjacency_list)
        count = 0
        visited_array = [False] * (len(isConnected))

        for i in range(0,len(isConnected)):
            if visited_array[i] == False:
                count += 1
                self.dfs(i,adjacency_list,visited_array)
                
        return count