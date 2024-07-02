#
# @lc app=leetcode id=199 lang=python3
#
# [199] Binary Tree Right Side View
#

from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def traversal(node: Optional[TreeNode], depth):
            if node is None:
                return
            if len(result) == depth:
                result.append(node.val)

            traversal(node.right, depth + 1)
            traversal(node.left, depth + 1)

        traversal(root, 0)
        return result


# @lc code=end
