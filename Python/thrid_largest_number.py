import sys

def Solution(nums):
    if len(nums) == 1:
        return nums[0]
    elif len(nums) == 2:
        return max(nums[0], nums[1])

    first = nums[0]
    second = -sys.maxsize
    third = -sys.maxsize

    for i in nums: 
        if i > first:	# Comparison for first 
            third = second 
            second = first 
            first = i 
        elif first > i and i > second:	# Comparison for second 
            third = second 
            second = i 
        elif second > i and i > third:	# Comparison for third 
            third = i 

    return first if third == -sys.maxsize else third

if __name__ == '__main__':
    print(Solution([2,2,3,1]))
    print(Solution([233,11,6,2,44,252,776,23,53,644,23,563]))
        
        