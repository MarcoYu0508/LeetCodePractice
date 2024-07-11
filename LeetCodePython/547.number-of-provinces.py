#
# @lc app=leetcode id=547 lang=python3
#
# [547] Number of Provinces
#

from typing import List


# @lc code=start
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        N = len(isConnected)
        visited = N * [False]
        count = 0

        for i in range(N):
            if not visited[i]:
                count += 1
                self.dfs(isConnected, i, visited)
        return count

    def dfs(self, isConnected: List[List[int]], i: int, visited: List[bool]):
        for j in range(len(isConnected[i])):
            if not visited[j] and isConnected[i][j] != 0:
                visited[j] = True
                self.dfs(isConnected, j, visited)


# @lc code=end
