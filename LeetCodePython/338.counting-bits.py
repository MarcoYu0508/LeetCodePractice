#
# @lc app=leetcode id=338 lang=python3
#
# [338] Counting Bits
#

from typing import List


# @lc code=start
class Solution:
    def countBits(self, n: int) -> List[int]:
        bits = [0] * (n + 1)

        for i in range(1, n + 1):
            bits[i] = 1 + bits[i & (i - 1)]

        return bits


# @lc code=end
