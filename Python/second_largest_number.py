import sys

def Solution():
    size = int(input())
    if size <= 1:
        return -2147483648
    largest = int(input()) # first number
    second_largest = largest 
    largest = int(input()) # second number
    if largest < second_largest:
            largest, second_largest = second_largest, largest
    for _ in range(2, size):
        new_number = int(input())   # keeps track of new numbers
        if new_number > largest:
            largest, second_largest = new_number, largest
        elif new_number > second_largest:
            second_largest = new_number

    return second_largest

if __name__ == '__main__':
    print(Solution())
    