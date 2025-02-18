# Aim : By considering the terms in the Fibonacci sequence whose values do not exceed four million, WAP to find the sum of the even-valued terms.
a,b = 0,1
sum = 0
while(b<=4000000):
     if(b%2==0):
           sum += b
     c = a+ b
     a = b
     b = c
print("Sum of even sequence below four million in fibonacci sequence " , sum )