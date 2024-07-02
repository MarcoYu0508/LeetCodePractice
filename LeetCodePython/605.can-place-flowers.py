#
# @lc app=leetcode id=605 lang=python3
#
# [605] Can Place Flowers
#

from typing import List


# @lc code=start
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)

        if length == 1:
            if flowerbed[0] == 0:
                n -= 1
            return n <= 0

        if flowerbed[0] == 0 and flowerbed[1] == 0:
            flowerbed[0] = 1
            n -= 1

        if flowerbed[length - 1] == 0 and flowerbed[length - 2] == 0:
            flowerbed[length - 1] = 1
            n -= 1

        for i in range(1, length - 1):
            if flowerbed[i] == 1:
                i += 2
                continue
            if flowerbed[i] == 0:
                if flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0:
                    flowerbed[i] = 1
                    n -= 1
                elif flowerbed[i + 1] == 1:
                    i += 2
            if n <= 0:
                return True
        return n <= 0


# @lc code=end

s = Solution()
print(s.canPlaceFlowers([0, 0, 0, 0, 1], 2))
