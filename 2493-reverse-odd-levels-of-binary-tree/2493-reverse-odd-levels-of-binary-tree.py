# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        queue = deque([root])
        level = 0

        while queue:
            currsize = len(queue)
            temp_list = []
            while currsize:
                node = queue.popleft()
                temp_list.append(node)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                currsize -= 1
            
            if level % 2:
                i,j = 0, len(temp_list) - 1

                while i < j:
                    temp = temp_list[i].val
                    temp_list[i].val = temp_list[j].val
                    temp_list[j].val = temp
                    i += 1
                    j -= 1
            level += 1
        return root