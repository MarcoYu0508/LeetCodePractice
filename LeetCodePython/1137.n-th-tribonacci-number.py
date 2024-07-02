#
# @lc app=leetcode id=1137 lang=python3
#
# [1137] N-th Tribonacci Number
#


# @lc code=start
class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1 or n == 2:
            return 1

        dp = [1] * (n + 1)

        dp[0] = 0

        for i in range(3, n + 1):
            dp[i] = dp[i - 2] + dp[i - 1] + dp[i - 3]

        return dp[n]


# @lc code=end
