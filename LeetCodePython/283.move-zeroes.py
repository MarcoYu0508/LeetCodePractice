#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#

from typing import List


# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        last_non_zero_index = 0
        for i in range(0, len(nums)):
            if nums[i] != 0:
                nums[last_non_zero_index] = nums[i]
                last_non_zero_index += 1

        for i in range(last_non_zero_index, len(nums)):
            nums[i] = 0


# @lc code=end
