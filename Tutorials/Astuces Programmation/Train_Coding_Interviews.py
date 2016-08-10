import numpy as np
import random
import math

L = 60

a = [1,2,3]
len(a)
b = random.sample(range(300),L)
b

for index, price in enumerate(b):
    if (index < 10):
        continue
    print(index,price)

#%%
# Test Q1
def maxprof(t):
    cmin = math.inf
    cmax = -math.inf
    cprof = - math.inf
    
    for i in range(len(t)):
        if (t[i]<cmin):
            cmin = t[i]
            cmax = t[i]
        else:
            cmax = max(cmax,t[i])
            cprof = max(cprof, cmax - cmin)
    
    return cprof

#%%
#Test Q2
c = []
for i in range(len(b)):
    c.append

def get_products_of_all_ints_except_at_index(t):
    if 0 in t:
        return 0
    
    lst = [1]*(len(t)-1)
    p=1
    q=1
    for i in range(1,len(t)):
        p *= t[i-1]
        lst[i]=p
        
    for j in range(1,len(t)):
        q *= t[len(t)-j]
        lst[len(t)-1 -j] *= q
        
    return lst
#%%
# Test Coins
    
def change_possibilities_top_down(amount_left, denominations_left):
    # base cases:
    # we hit the amount spot on. yes!
    if amount_left == 0: return 1
    # we overshot the amount left (used too many coins)
    if amount_left < 0: return 0
    # we're out of denominations
    if len(denominations_left) == 0: return 0

    print("checking ways to make", amount_left, " with ", denominations_left)

    # choose a current_coin
    current_coin, rest_of_coins = denominations_left[0], denominations_left[1:]

    # see how many possibilities we can get
    # for each number of times to use current_coin
    num_possibilities = 0
    while amount_left >= 0:
        num_possibilities += change_possibilities_top_down(amount_left, rest_of_coins)
        amount_left -= current_coin

    return num_possibilities
        
#%% Fibonacci numbers
class Fibber:
    def __init__(self):
        
