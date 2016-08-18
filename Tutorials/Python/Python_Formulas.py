# -*- coding: utf-8 -*-
"""
Created on Tue May 24 16:32:15 2016

@author: Ferdinand
"""

#%% Dataframes

#create dataframe

# Importing dataframe from/to csv
taxi500 = pd.read_csv('C:\Users\Ferdinand\Documents\NYU\Data\taxi500.csv', header = 0, names=["node_id","count","datetime"], sep = ",",index_col=False)
df.to_csv(path='path/to/file',sep=',',header= True, columns=['latitude','longitude'], index=False)

# Manipulating dataframes
df.loc[df['column_name'] == some_value] # select rows
df.loc[df['column_name'].isin(some_values)]
u = taxi.loc[:,"pick_x"] #get column named 'pick_x'

#columns names
df.columns[index_col]

#Delete column
df = df.drop('column_name', 1)
df.drop('column_name', axis=1, inplace=True)
df.drop(df.columns[[0, 1, 3]], axis=1)  # df.columns is zero-based pd.Index 

#Max value of column of dataframe
max_lati = coord_graph.max(axis=0)['latitude']
max_longi = coord_graph.max(axis=0)['longitude']
min_lati = coord_graph.min(axis=0)['latitude']
min_longi = coord_graph.min(axis=0)['longitude']

test= np.array(coord_graph['longitude'])
test.sort()
a[a[:,'column_you_use_to_sort'].argsort()]

#apply function to column of dataframe
def f(x):    
   return x[0] + x[1]
df.apply(f, axis=1) # you will sum columns with axis = 1

# set an index with a column 
coord_indexed = coord.set_index(coord['cell_id'])

# sort by columns
result = df.sort(['c','d'], ascending=[1,0])

# Change element type of column
df[columns] = df[columns].astype('float32')
counts['count'] = pd.to_numeric(counts['count'])
df[['col2','col3']] = df[['col2','col3']].apply(pd.to_numeric)

# Filter rows with value lists
df[df['col1'].isin([3, 6])]

## -------- grouping and summarizing data ----------
bygroup_treatment = data.groupby(['Group', 'Treatment']) #grouping according to two cols
bygroup_treatment = data.groupby(['Group', 'Treatment'], as_index=False) # to prevent columns becoming index
bygroup_treatment['RelativeFitness'].aggregate(np.sum) #sum in every group

##--------- text processing in data frame ----------

#split string column into multiple columns
ctg0['year'] = ctg0['datetime'].str.split('-').str.get(0)

#%% Datetime
# datetime package
ts = datetime.datetime.fromtimestamp(ts_epoch).strftime('%Y-%m-%d %H:%M:%S') # Epoch time in YY-MM-DD HH:MM:SS
# datetime with pandas
t = pd.DataFrame({'date':[526492755,526492756,526492757,526492758], 'ID':[1,2,3,4]})
pd.to_datetime(t['date'], unit='s') #--> converts to %Y-%m-%d %H:%M:%S

# Extract day / hour... from pandas datetime column (datetime64[ns])
index = pd.DatetimeIndex(taxi500b['pickup_time'])
index.hour
index.day

#%% File reading and writing

# Writing and reading file
'{:02}'.format(k) 
counts1110 = open("/home/ferdinand/Documents/NYU/Data/counts1110.csv", "w")
counts1110.write("cell_id, count, date \n")
counts1110.close()
taxi.readline()

#Copying file input in copyFile
copyFile = open("filename.txt", "w")
inputFile = open("inputfilename.txt")
for line in inputFile:
    copyFile.write(line)
    
#Inserting text in text file in place
import fileinput
hola = open("/home/ferdinand/Documents/NYU/satscan/xp_roads_elp/iterative/hola.txt","w")
hola.write("hola1\n")
hola.write("hola2\n")
hola.write("hola3\n")
hola.close()

for line in fileinput.input("/home/ferdinand/Documents/NYU/satscan/xp_roads_elp/iterative/hola.txt", inplace = 1):      
    print line.replace("\n","")    
    if (line[4] == str(2)):
        print "bonjour"

#%% Strings & text processing

# String manipulation
string.split(',')

# remove space characters from string
s.replace(" ","")

#remove a character at position index
line = line[:index] + line[index+1:]


#%% Lists

#concatenate two lists
list1 + list2

# list of lists
list1=[]
list1.append(['a','b','c'])
list1.append(['a','g','h','j'])

# check if value is in list
value in list1

# convert all strings of a list to int values
results_list = ['1', '3', '4']
results_list = map(int, results_list)

## --------------- running command lines from python script -----------------
from subprocess import call
call(["ls", "-l"])
