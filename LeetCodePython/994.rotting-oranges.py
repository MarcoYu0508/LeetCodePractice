#
# @lc app=leetcode id=994 lang=python3
#
# [994] Rotting Oranges
#

from typing import List
from collections import deque


# @lc code=start
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row_cnt = len(grid)
        col_cnt = len(grid[0])

        fresh_cnt = 0

        rotten = deque()

        for row in range(row_cnt):
            for col in range(col_cnt):
                if grid[row][col] == 2:
                    rotten.append((row, col))
                elif grid[row][col] == 1:
                    fresh_cnt += 1

        minutes_taken = 0

        while rotten and fresh_cnt > 0:
            minutes_taken += 1

            for _ in range(len(rotten)):
                row, col = rotten.popleft()

                for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    target_row, target_col = row + dx, col + dy

                    if (
                        target_row < 0
                        or target_row == row_cnt
                        or target_col < 0
                        or target_col == col_cnt
                    ):
                        continue

                    if (
                        grid[target_row][target_col] == 0
                        or grid[target_row][target_col] == 2
                    ):
                        continue

                    fresh_cnt -= 1

                    grid[target_row][target_col] = 2

                    rotten.append((target_row, target_col))

        return minutes_taken if fresh_cnt == 0 else -1


# @lc code=end
