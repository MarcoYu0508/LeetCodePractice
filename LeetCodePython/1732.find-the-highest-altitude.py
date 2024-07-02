#
# @lc app=leetcode id=1732 lang=python3
#
# [1732] Find the Highest Altitude
#

from typing import List


# @lc code=start
class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        max_alt = 0
        current_alt = 0
        for alt in gain:
            current_alt += alt
            max_alt = max(max_alt, current_alt)
        return max_alt


# @lc code=end
