#
# @lc app=leetcode id=238 lang=python3
#
# [238] Product of Array Except Self
#

from typing import List


# @lc code=start
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        size = len(nums)

        res = [1] * size
        prod = nums[-1]

        for i in range(1, size):
            res[i] = res[i - 1] * nums[i - 1]

        for i in range(size - 2, -1, -1):
            res[i] *= prod
            prod *= nums[i]

        return res


# @lc code=end
