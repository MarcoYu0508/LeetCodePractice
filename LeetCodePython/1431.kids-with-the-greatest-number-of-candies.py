#
# @lc app=leetcode id=1431 lang=python3
#
# [1431] Kids With the Greatest Number of Candies
#
from typing import List


# @lc code=start
class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        result: List[bool] = []
        max_candies = max(candies)
        for candy in candies:
            result.append(extraCandies + candy >= max_candies)
        return result


# @lc code=end
