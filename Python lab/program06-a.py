# AIM :  Write a program to count the numbers of characters in the string and store them in a dictionary data structure
string = input("Enter a String : ")
char_count = {}
for char in string:
     if char in char_count:
          char_count[char]+=1
     else:
          char_count[char] = 1
print("count of the characters for the string " , char_count)