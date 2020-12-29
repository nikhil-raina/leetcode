# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        def get_node_and_depth(val, root):
            queue = list()
            depth = 0
            parent = root
            queue.append((root, depth, parent))

            while len(queue) != 0:
                temp, depth, parent = queue.pop(0)
                if temp.val == val:
                    return temp, depth, parent
                if temp.val != 0:
                    if temp.left:
                        queue.append((temp.left, depth + 1, temp))
                    if temp.right:
                        queue.append((temp.right, depth + 1, temp))
            return root, -1, None

        x, x_depth, x_parent = get_node_and_depth(x, root)
        if not x_parent:
            return False
        y, y_depth, y_parent = get_node_and_depth(y, root)
        if not y_parent:
            return False

        if x_depth == -1 or y_depth == -1 or x_parent.val == y_parent.val:
            return False
        return x_depth == y_depth


A = Solution()
root = TreeNode(1)
left_root = TreeNode(2)
right_root = TreeNode(3)
left_left_root = TreeNode()
left_right_root = TreeNode(4)
right_left_root = TreeNode()
right_right_root = TreeNode(5)
left_root.left = left_left_root
left_root.right = left_right_root
right_root.left = right_left_root
right_root.right = right_right_root
root.left = left_root
root.right = right_root
a4 = TreeNode(7)
a4 = TreeNode(7)


print(A.isCousins(root, 5, 4)) 