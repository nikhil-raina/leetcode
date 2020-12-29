# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        queue = list()
        result = list()
        queue.append(root)
        is_right = True
        while len(queue) != 0:
            queue_size = len(queue)
            inner_list = list()
            while queue_size != 0:
                current_node = queue.pop(0)
                inner_list.append(current_node.val)
                if current_node and current_node.val != 0:
                    if current_node.right:
                        queue.append(current_node.right)
                    if current_node.left:
                        queue.append(current_node.left)
                        
                queue_size -= 1
            
            if is_right:
                inner_list.reverse()
                    
            is_right = not is_right
            result.append(inner_list)
        return result

A = Solution()
root = TreeNode(1)
left_root = TreeNode(2)
right_root = TreeNode(3)
left_left_root = TreeNode()
left_right_root = TreeNode()
right_left_root = TreeNode(6)
right_right_root = TreeNode(7)
left_root.left = left_left_root
left_root.right = left_right_root
right_root.left = right_left_root
right_root.right = right_right_root
root.left = left_root
root.right = right_root
a4 = TreeNode(7)
a4 = TreeNode(7)


print(A.zigzagLevelOrder(root)) 