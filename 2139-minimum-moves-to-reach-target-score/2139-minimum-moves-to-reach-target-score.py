class Solution:
    def minMoves(self, target: int, maxDoubles: int) -> int:
        operations = 0
        
        while target != 1:
            if target & 1:
                target -= 1
                operations += 1
            else:
                if maxDoubles > 0:
                    target = target >> 1
                    operations += 1
                    maxDoubles -= 1
                else:
                    operations += target - 1
                    break
        
        return operations

