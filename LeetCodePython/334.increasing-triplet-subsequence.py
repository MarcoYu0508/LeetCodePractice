#
# @lc app=leetcode id=334 lang=python3
#
# [334] Increasing Triplet Subsequence
#

from math import inf
from typing import List


# @lc code=start
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        first = inf
        second = inf
        for num in nums:
            if second < num:
                return True
            if num <= first:
                first = num
            else:
                second = num

        return False


# @lc code=end
