#  Write function to compute gcd, lcm of two numbers. Each function shouldn’t exceed one line.
import math 
gcd = lambda a, b: math.gcd(a, b)
lcm = lambda a, b: abs(a * b) // math.gcd(a, b)
a = int(input("Enter first number: "))
b = int(input("Enter second number: "))
print("GCD of", a, "and", b, "is:", gcd(a, b)) 
print("LCM of", a, "and", b, "is:", lcm(a, b))
