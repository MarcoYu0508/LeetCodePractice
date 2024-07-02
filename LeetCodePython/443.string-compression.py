#
# @lc app=leetcode id=443 lang=python3
#
# [443] String Compression
#

from typing import List


# @lc code=start
class Solution:
    def compress(self, chars: List[str]) -> int:
        group_idx = 0
        currentChar = chars[0]
        count = 1

        for i in range(1, len(chars)):
            if chars[i] == currentChar:
                count += 1
            else:
                if count > 1:
                    count_str = str(count)
                    for j in range(len(count_str)):
                        group_idx += 1
                        chars[group_idx] = count_str[j]

                group_idx += 1
                chars[group_idx] = chars[i]
                currentChar = chars[i]
                count = 1

        if count > 1:
            count_str = str(count)
            for j in range(len(count_str)):
                group_idx += 1
                chars[group_idx] = count_str[j]

        return group_idx + 1


# @lc code=end
