#
# @lc app=leetcode id=1768 lang=python3
#
# [1768] Merge Strings Alternately
#


# @lc code=start
class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        m = len(word1)
        n = len(word2)

        result = ""

        for i in range(max(m, n)):
            if i < m:
                result += word1[i]
            if i < n:
                result += word2[i]

        return result


# @lc code=end
