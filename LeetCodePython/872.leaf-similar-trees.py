#
# @lc app=leetcode id=872 lang=python3
#
# [872] Leaf-Similar Trees
# ]

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
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        leaves1 = self.dfs(root1, [])
        leaves2 = self.dfs(root2, [])

        return leaves1 == leaves2

    def dfs(self, node: Optional[TreeNode], leaves: List[int]) -> List[int]:
        if node == None:
            return leaves

        if node.left == None and node.right == None:
            leaves.append(node.val)
        else:
            leaves = self.dfs(node.left, leaves)
            leaves = self.dfs(node.right, leaves)
        return leaves


# @lc code=end
