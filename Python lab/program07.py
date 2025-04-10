# Write a program to count frequency of characters in a given file. Can you use character frequency to tell whether the given file is a Python program file, C program file or a text file?

char_freq = {}


filepath = input("Enter file path: ")

with open(filepath, 'r') as file:
    for line in file:
        for char in line:
            if char in char_freq: char_freq[char] += 1
            else: char_freq[char] = 1

for ch, cnt in char_freq.items():
    print(ch, ":", cnt)

python_keywords = ['def', 'import', 'self', 'print', 'and', 'class']
c_keywords = ['#include', 'int', 'void', 'printf', 'scanf', 'main']

with open(filepath, 'r') as file:
        content = file.read().lower()
        
       
        python_count = sum(1 for word in python_keywords if word in content)
        c_count = sum(1 for word in c_keywords if word in content)
if python_count > c_count :
    print("It is a Python file")
elif c_count > python_count : print("It is a  C file")
else: print("it is  a text file")