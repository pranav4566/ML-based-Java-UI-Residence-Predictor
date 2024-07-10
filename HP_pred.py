
import numpy as np
import sys

# from sklearn.metrics import accuracy_score,confusion_matrix
import seaborn as sns
import matplotlib.pyplot as plt

import pandas as pd
from math import floor

import matplotlib.pyplot as plt
from sklearn.metrics import r2_score

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder

from sklearn.linear_model import Lasso
from sklearn.model_selection import cross_val_score,KFold
from sklearn.linear_model import ElasticNet
from sklearn.ensemble import RandomForestRegressor # create regressor object
from sklearn.linear_model import LinearRegression


pd.options.mode.chained_assignment = None
print("Hello")
df=pd.read_csv("pune.csv")

df.drop(labels=['society','availability'],axis=1,inplace=True)

bath_median=float(floor(df.bath.median()))
balcony_median=float(floor(df.balcony.median()))

df.bath=df.bath.fillna(bath_median)
df.balcony=df.balcony.fillna(balcony_median)

df=df.dropna()

df['size']=df['size'].apply(lambda x:float(x.split()[0]))


def calcsqt(x):

    t = x.split('-')

    if len(t)==2:
        return (float(t[0])+float(t[1])/2)
    try:
        return float(x)
    except:
        return None

for i in range(df.shape[0]):
    try:
        x=df['total_sqft'][i]
        df['total_sqft'][i] =calcsqt(x)
    except KeyError:
        continue



df['site_location'] = df['site_location'].apply(lambda x: x.strip())
# print(df.head())

le=LabelEncoder()

l1=df['site_location'].unique()
df['site_location']=le.fit_transform(df['site_location'])
l1v=df['site_location'].unique()
dict1={l1[i]:l1v[i] for i in range(len(l1))}


l2=df['area_type'].unique()
df['area_type']=le.fit_transform(df['area_type'])
l2v=df['area_type'].unique()
dict2={l2[i]:l2v[i] for i in range(len(l2))}


loc_stats = df.groupby('site_location')['site_location'].agg('count').sort_values(ascending=False)
loc_stats_less_than_10 = loc_stats[loc_stats<=10]

df["total_sqft"] = df["total_sqft"].astype(float)



# print(df.info())

df['price_per_sqft'] = df['price']*100000/df['total_sqft']
# print(df.head(10))

# print(df.shape)

df['area_type']=le.fit_transform(df['area_type'])

def remove_outlier(df_in, col):
  for i in col:
    q1 = df_in[i].quantile(0.25)
    q3 = df_in[i].quantile(0.75)
    iqr = q3-q1 #Interquartile range
    fence_low  = q1-1.5*iqr
    fence_high = q3+1.5*iqr
    df_out = df_in.loc[(df_in[i] > fence_low) & (df_in[i] < fence_high)]
  return df_out

df2 = remove_outlier(df, ['price_per_sqft'])
# print(df2.shape)


def plot_scatter_chart(df, location):
    bhk2 = df[(df['site_location']==location) & (df['size']==2)]
    bhk3 = df[(df['site_location']==location) & (df['size']==3)]
    plt.figure(figsize=(20,15))
    plt.scatter(bhk2['total_sqft'], bhk2['price'], color='blue', label='2 BHK',s=50)
    plt.scatter(bhk3['total_sqft'], bhk3['price'], color='green', marker='+', label='3 BHK',s=50)
    plt.xlabel('Total Square Feet Area')
    plt.ylabel('Price')
    plt.title(location)
    plt.legend()
    # plt.show()

# plot_scatter_chart(df2, 'Kondhwa')

def remove_bhk_outliers(df):
    exclude_indices = np.array([])
    for location, location_df in df.groupby('site_location'):
        bhk_stats = {}
        for bhk, bhk_df in location_df.groupby('size'):
            bhk_stats[bhk] = {
                'mean' : np.mean(bhk_df['price_per_sqft']),
                'std' : np.std(bhk_df['price_per_sqft']),
                'count' : bhk_df.shape[0]
            }
        for bhk, bhk_df in location_df.groupby('size'):
            stats = bhk_stats.get(bhk-1)
            if stats and stats['count']>5:
                exclude_indices = np.append(exclude_indices, bhk_df[bhk_df['price_per_sqft']<(stats['mean'])].index.values)
    return df.drop(exclude_indices, axis='index')

df2 = remove_bhk_outliers(df2)

# plot_scatter_chart(df2, 'Kondhwa')

# plt.figure(figsize=(15,10))
# plt.xlabel('Price Per Square Feet')
# plt.ylabel('Count')
# sns.histplot(df2['price_per_sqft'], kde=True, bins=5)
# plt.show()

df2[df2['bath']>10]

# plt.figure(figsize=(15,10))
# plt.xlabel('Bathrooms')
# plt.ylabel('Count')
# sns.histplot(df2['bath'], kde=True, bins=5)


df2 = df2[df2['bath']<df2['size']+2]

df2.drop('price_per_sqft',axis=1, inplace=True)
# dummies = pd.get_dummies(df2['site_location']).drop('Other', axis=1)
# df3 = pd.concat([df2, dummies], axis=1).drop('site_location', axis=1)

X = df2.drop('price', axis=1)
Y = df2['price']

X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=72)

model = RandomForestRegressor(n_estimators = 1000, random_state = 0)
# model=LinearRegression()
# model=Lasso(alpha=100)
# model = ElasticNet(alpha=10, l1_ratio=0.5)
model.fit(X_train.values, Y_train)  
y_pred=model.predict(X_test)

# print(r2_score(Y_test,y_pred))

# kfold_6=KFold(n_splits=5,random_state=53,shuffle=True)
# scores_6=cross_val_score(model,X,Y,cv=kfold_6)
# print(f"Accuracy score:{scores_6*100}")
# print(f"Accuracy scores using KFold method is:{round(scores_6.mean()*100,2)}") #75.28%

area_type = dict2[sys.argv[1]]
size=sys.argv[2]
n_size=size.split()[0]
total_sqft = float(sys.argv[3])
bath = int(sys.argv[4])
balcony = int(sys.argv[5])
location = dict1[sys.argv[6]]


# area_type = dict2["Super built-up  Area"]
# size=3
# total_sqft = 2600
# bath = int(3)
# balcony = int(2)
# location = dict1["Baner"]

# print([area_type ,n_size ,total_sqft ,bath ,balcony ,location])
inp=pd.array([area_type ,n_size ,total_sqft ,bath ,balcony ,location])
ip=inp.reshape((1,-1))
print(inp)
y_pred=model.predict(ip)
print("Cost:",y_pred)
var=str(y_pred[0])

with open("predict.txt", "w") as f:
    f.write(var)



