# AIM :  Write a program to use split and join methods in the string and trace a birthday of a person with a dictionary data structure
b_day = input ("Enter your birth day (dd mm yy) : ")
string = b_day.split()
dict = {
     "date": string[0],
     "month" : string[1],
     "year" : string[2]
}

it = []
for key , value in dict.items():
    it = it + [key +" " + value]
res = ", ".join(it)

print(res)
