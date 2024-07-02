#
# @lc app=leetcode id=450 lang=python3
#
# [450] Delete Node in a BST
#

from typing import Optional


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
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if root is None:
            return None

        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            root.val = self.minValue(root.right)
            root.right = self.deleteNode(root.right, root.val)
        return root

    def minValue(self, root: TreeNode) -> int:
        minv = root.val
        while root.left != None:
            minv = root.left.val
            root = root.left
        return minv


# @lc code=end
