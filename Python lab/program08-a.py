filepath = input("Enter file path: ")

with open(filepath, 'r') as file:
    for line in file:
        rev_line = line.rstrip()[::-1]  
        print("original : " + line.rstrip())
        print("reverse : "+  rev_line)