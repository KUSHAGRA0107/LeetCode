# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        queue = deque([root])
        minOperations = 0

        def getminOperations(original):
            target = sorted(original)
            hashMap = {}
            swaps = 0
            # To check the original position in the sortedlist
            for i in range(len(original)):
                hashMap[level[i]] = i
            
            for i in range(len(original)):
                if original[i] != target[i]:
                    swaps += 1
                    curr_position = hashMap[target[i]]
                    original[curr_position] = original[i]
                    hashMap[original[i]] = curr_position


            return swaps 

            

        
        while queue:
            currentSize = len(queue)
            level = []
            while currentSize:
                node = queue.popleft()
                level.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

                currentSize -= 1
            minOperations += getminOperations(level)
        return minOperations
