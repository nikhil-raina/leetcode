def maxProfit(prices):
        smallest = prices[0]
        largest = prices[0]
        profit = 0
        for i in range(len(prices)):
            if prices[i] > largest:
                largest = prices[i]
                profit = largest - smallest if largest - smallest > profit else profit
            
            elif prices[i] < smallest:
                smallest = prices[i]
                largest = smallest
                    
        return profit  


def main():
    print(maxProfit([7,1,5,3,6,4]))

if __name__ == '__main__':
    main()
    