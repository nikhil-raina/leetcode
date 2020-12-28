# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        def solve(root, diameter):
            if not root:
                return -1
            
            left = solve(root.left, diameter) + 1
            right = solve(root.right, diameter) +1
            
            diameter = max(diameter, left + right)
            
            return max(left, right)
        
        return solve(root, 0)