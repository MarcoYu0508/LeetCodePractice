#
# @lc app=leetcode id=746 lang=python3
#
# [746] Min Cost Climbing Stairs
#

from typing import List


# @lc code=start
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        for i in range(2, n):
            cost[i] = cost[i] + min(cost[i - 1], cost[i - 2])

        return min(cost[n - 1], cost[n - 2])


# @lc code=end
