#
# @lc app=leetcode id=1207 lang=python3
#
# [1207] Unique Number of Occurrences
#

from typing import List
from collections import Counter


# @lc code=start
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        freq_dict = Counter(arr)

        freq_set = set()

        for v in freq_dict.values():
            freq_set.add(v)

        return len(freq_set) == len(freq_dict)


# @lc code=end
