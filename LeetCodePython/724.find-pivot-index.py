#
# @lc app=leetcode id=724 lang=python3
#
# [724] Find Pivot Index
#

from typing import List


# @lc code=start
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        summary = sum(nums)
        left_summary = 0

        for i in range(len(nums)):
            if left_summary == summary - left_summary - nums[i]:
                return i
            left_summary += nums[i]

        return -1


# @lc code=end
