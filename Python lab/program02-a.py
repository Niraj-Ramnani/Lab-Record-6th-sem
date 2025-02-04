# Aim :  Write a program to compute distance between two points taking input from the user
import math as m
print("For first point enter the values for the x and y cordinate")
x1 = float(input())
y1 = float(input())
print("For second point enter the values for the x and y cordinate")
x2 = float(input())
y2 = float(input())
res = m.sqrt((x2 - x1)**2 + (y2 -y1)**2)
print("Distance between the two point is " , res)