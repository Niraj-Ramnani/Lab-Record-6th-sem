# Aim : Find the sum of all the primes below two million
sum = 0
for i in range (2,2000000):
     is_prime = True
     for j in range (2,int((i**0.5))+1):
          if(i%j==0):
               is_prime = False
               break
     if(is_prime):
          sum = sum + i
print("sum of all the primes below two million ",sum)
     