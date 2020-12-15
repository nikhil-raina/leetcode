def max_product(nums):
    ans = nums[0] if nums else 0
    mx, mn = 1, 1
    
    for n in nums:
        arr = [n, n * mx, n * mn]
        mx, mn = max(arr), min(arr)
        ans = max(ans, mx)

    return ans


if __name__ == '__main__':
    print(max_product([2,5,4,3,8,0,5,6,2,-5,-6]))
    