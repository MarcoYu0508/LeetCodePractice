#
# @lc app=leetcode id=1679 lang=python3
#
# [1679] Max Number of K-Sum Pairs
#


from typing import List
from collections import Counter


# @lc code=start
class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        count = 0
        map = Counter(nums)

        for num, num_cnt in map.items():
            diff = k - num
            if num < diff or diff not in map:
                continue

            count += min(num_cnt, map[diff]) if num != diff else num_cnt // 2

        return count


# @lc code=end
