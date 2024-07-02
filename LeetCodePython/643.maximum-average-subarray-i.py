#
# @lc app=leetcode id=643 lang=python3
#
# [643] Maximum Average Subarray I
#

from typing import List


# @lc code=start
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        summary = sum(nums[:k])
        max_avg = summary / k

        for i in range(len(nums) - k):
            summary = summary - nums[i] + nums[i + k]
            max_avg = max(max_avg, summary / k)
        return max_avg


# @lc code=end
