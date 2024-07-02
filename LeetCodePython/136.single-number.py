#
# @lc app=leetcode id=136 lang=python3
#
# [136] Single Number
#

from typing import List
import functools


# @lc code=start
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        repeats = 0
        if nums != []:
            for i in nums:
                repeats ^= i
            return repeats


# @lc code=end
