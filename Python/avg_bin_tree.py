# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        queue = list()
        queue.append(root)
        result = list()
        while len(queue) != 0:
            temp = list()
            queue_size = len(queue)
            while queue_size != 0:
                node = queue.pop(0)     # takes the first node out from the queue
                temp.append(node.val)
                
                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)
                
                queue_size -= 1
            if len(temp) >= 2:
                sum = 0
                for num in temp:
                    sum += num
                result.append((sum) / len(temp))
            else:
                result.append(temp[0])
            
        return result


A = Solution()
root = TreeNode(3)
left_root = TreeNode(1)
right_root = TreeNode(5)
left_left_root = TreeNode(0)
left_right_root = TreeNode(2)
right_left_root = TreeNode(4)
right_right_root = TreeNode(6)
left_root.left = left_left_root
left_root.right = left_right_root
right_root.left = right_left_root
right_root.right = right_right_root
root.left = left_root
root.right = right_root
a4 = TreeNode(7)
a4 = TreeNode(7)


print(A.levelOrderBottom(root)) 
       