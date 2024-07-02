#
# @lc app=leetcode id=739 lang=python3
#
# [739] Daily Temperatures
#

from typing import List


# @lc code=start
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)

        temp_stack = []

        for idx, temp in enumerate(temperatures):
            while temp_stack and temperatures[temp_stack[-1]] < temp:
                temp_idx = temp_stack.pop()
                result[temp_idx] = idx - temp_idx
            temp_stack.append(idx)

        return result


# @lc code=end
