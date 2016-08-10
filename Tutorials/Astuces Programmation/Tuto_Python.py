# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np
from sklearn import metrics

#================== Data Frames ==================

# Create new data frame
d = pd.DataFrame()
DF = pd.DataFrame({'AAA' : [4,5,6,7], 'BBB' : [10,20,30,40],'CCC' : [100,50,-30,-50]});

# Create new column
d['newname']=[0,2,4]
# Delete column
d.drop('colName', 1)
DF.drop(DF.columns[[0, 1, 3]], axis=1)
# Rename column
df = df.rename(columns={'$a': 'a', '$b': 'b'})

# Rows and columns manipulation
test = sirta15[0:10] # take rows 0 to 9
test = sirta15[:5] # take the first 5 rows
test = sirta15[-49887:] #take the last 49887 rows
test = sirta15[[1,2]] # columns 1 and 2
test = sirta15.iloc[0:10,1:10] # select rows then columns
test = sirta15.iloc[:,[1,5,6]] # select rows then colums by index
test = sirta15.loc[:,['P1(W)','Tp1(C)']] # select these 2 columns
test = sirta15.loc[10:50, 'P1(W)':'Drz2(W/m2)'] # select columns between P1 and Drz2 and rows bet 10 & 49
test = sirta15[::-1] # ordre inverse
weekdays.loc[np.array(calls['DAY_WE_DS'] == wd),wd] = 1 # keep rows if a certain column value is equal to a certain value
meteo = meteo.loc[meteo['DEPT'].isin(deptlist)] # keep rows if a certain column value is in a certain list
test['column'].unique() # returns array of all values taken by column

# Fill NAs with 0
submission_long.fillna(0)

# ------ Group by -------
grouped = df.groupby('A')
grouped.aggregate(np.sum)
# Different functions to columns
grouped.agg({'C' : 'sum', 'D' : 'std'})

test= pd.DataFrame({'a':[1,2,2,2,2,3,4,2],'b':[3,2,-6,-6,-6,5,8,2], 'c':[5,6,9,8,7,7,3,-8]})
test = test.groupby(['a','b'], as_index=False) #as_index=False keeps columns index for colums used for grouping
test = test.aggregate(np.sum)

# ================ Lists ==================
test = ['hey','my','my']
test.remove('hey')
test.append('yo')
list.extend(('yo','yeah','yup'))

#get position of element in list
test.index(element)


# =============== Strings ==============

i=3
str0 = 'hello' + str(i)

# ================ Maths =============
4 % 3

# ================ Arrays =============
a= np.zeros(length)
test = np.repeat(1,length)

# ============= Dictionary ========
dic = {'a':[4,5,6], 'b':[7,7,7]}
dic['c'] = [9,1,0] # add item
dic.update({'c': [9,1,0]}) # equivalent

#================== Other ==============

#Integral of function
testx = np.array([0,2,6])
testy=np.array([2,2,6])
metrics.auc(testx,testy)
