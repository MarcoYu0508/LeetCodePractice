#
# @lc app=leetcode id=394 lang=python3
#
# [394] Decode String
#


# @lc code=start
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for c in s:
            if c != "]":
                stack.append(c)
            else:
                temp = ""
                while stack[-1] != "[":
                    temp = stack.pop() + temp
                stack.pop()

                count = 1
                number = 0
                while len(stack) > 0 and stack[-1].isdigit():
                    number = count * int(stack.pop()) + number
                    count *= 10

                temp = temp * number
                stack.append(temp)
        return "".join(stack)


# @lc code=end


s = Solution()
# print(s.decodeString("3[a]2[bc]"))
# print(s.decodeString("3[a2[c]]"))
print(s.decodeString("100[leetcode]"))
