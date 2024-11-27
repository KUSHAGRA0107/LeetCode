from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        word_len = len(word)
        visited = [[False for _ in range(cols)] for _ in range(rows)]

        def helper(index, i, j):
            # Base cases
            if index == word_len:  # All characters matched
                return True
            if i < 0 or j < 0 or i >= rows or j >= cols:  # Out of bounds
                return False
            if visited[i][j] or board[i][j] != word[index]:  # Already visited or mismatch
                return False

            # Mark as visited
            visited[i][j] = True

            # Explore in all four directions
            found = (
                helper(index + 1, i, j - 1) or  # Left
                helper(index + 1, i, j + 1) or  # Right
                helper(index + 1, i - 1, j) or  # Up
                helper(index + 1, i + 1, j)     # Down
            )

            # Backtrack
            visited[i][j] = False
            return found

        # Start the search from every cell
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:  # Potential starting point
                    if helper(0, i, j):
                        return True
        return False
