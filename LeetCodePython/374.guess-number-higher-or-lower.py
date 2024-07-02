#
# @lc app=leetcode id=374 lang=python3
#
# [374] Guess Number Higher or Lower
#


# @lc code=start
# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
def guess(num: int) -> int:
    pick = 6
    if num > pick:
        return -1
    elif num < pick:
        return 1
    return 0


class Solution:
    def guessNumber(self, n: int) -> int:
        left = 1
        right = n
        mid = (left + right) // 2

        guess_result = guess(mid)

        while guess_result != 0:
            if guess_result > 0:
                left = mid + 1
            else:
                right = mid - 1

            mid = (left + right) // 2
            guess_result = guess(mid)

        return mid


# @lc code=end
