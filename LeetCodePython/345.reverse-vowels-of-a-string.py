#
# @lc app=leetcode id=345 lang=python3
#
# [345] Reverse Vowels of a String
#


# @lc code=start
class Solution:
    def reverseVowels(self, s: str) -> str:
        characters = list(s)
        vowels = set("aeiouAEIOU")
        i = 0
        j = len(s) - 1
        while i < j:
            if characters[i] not in vowels:
                i += 1
            elif characters[j] not in vowels:
                j -= 1
            else:
                characters[i], characters[j] = characters[j], characters[i]
                i += 1
                j -= 1

        return "".join(characters)


# @lc code=end
