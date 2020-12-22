
def maxProfit(prices):
    bought = prices[0]
    max_price = prices[0]
    sum = 0
    previous_bought = 0
    previous_max_price = 0
    for i in range(1, len(prices)):
        if bought > prices[i]:
            bought = prices[i]
            max_price = bought
        elif max_price < prices[i]:
            max_price = prices[i]
        else:
            sum += max_price - bought
            previous_bought = bought
            previous_max_price = max_price
            bought = prices[i]
            max_price = bought

    if previous_bought != bought or previous_max_price != max_price:
        return sum + max_price - bought

    return sum 



def main():
    print(maxProfit([8,7,6,5,3,1]))

if __name__ == '__main__':
    main()
    