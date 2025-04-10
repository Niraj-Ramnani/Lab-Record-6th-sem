filepath = input("Enter file path: ")


char_count = 0
word_count = 0 
line_count = 0


with open(filepath, 'r' ) as file:
    for line in file:
        line_count += 1
        char_count += len(line)
        word_count += len(line.split())


print("Number of lines     :", line_count)
print("Number of words     :", word_count)
print("Number of characters:", char_count)
